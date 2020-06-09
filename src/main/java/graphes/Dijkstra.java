/*
 * Copyright 2020 Yassine AZIMANI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package graphes;

import exceptions.GraphException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Dijkstra est utilisé pour calculer les chemins les plus courts à partir de graphes.
 * On peut l'utiliser pour calculer le chemin le plus court grâce à la distance la plus courte
 * ou à la consommation la plus petite possible etc. (distance/consommation etc. = poids).
 */
public class Dijkstra {

    /**
     * Poids/Graphe des différents noeuds. Les noeuds qui ne sont pas désservis doivent
     * être initialisés à null.
     */
    private Float weights[][];

    /**
     * Noeuds du graphe à traiter.
     */
    private List<String> nodes;

    /**
     * Indices des noeuds traités.
     */
    private List<Integer> nodesDone;

    /**
     * Distances cumulées à partir du noeud source vers les autres noeuds du graphe.
     */
    private float[] distances;

    /**
     * Répertorie les indices (Ville) qui précédent un autre indice (ville).
     */
    private int[] previous;

    /**
     * Indice du noeud de départ.
     */
    private int idxDepart;

    private final String separatorCities = " -> ";

    /**
     * Initialise une instance Dijkstra
     * @param weights Distances entre les différents noeuds du graphe sous forme de matrice carrée
     * @param cities Nom des villes composant le graphe, ils représentent les noeuds du graphe (sommets)
     */
    public Dijkstra(Float[][] weights, final String[] cities) {
        this.reinit(weights, cities);
    }// Dijkstra()

    /**
     * Cette fonction doit être obligatoirement appelée si on a
     * l'intention d'appeler ${@see calculateShortPath} plusieurs fois de
     * suite.
     */
    public void reinit(Float[][] weights, final String[] cities){
        this.weights = weights;
        // éviter UnsupportedOperationException en utilisant l'implémentation ArrayList :
        this.nodes = cities != null ? new ArrayList<>(Arrays.asList(cities)) : new ArrayList<>();
        this.distances = new float[cities != null ? cities.length : 1];
        this.previous = new int[cities != null ? cities.length : 1];
        this.nodesDone = new ArrayList<>();
    }// clean()

    /**
     * Calcule le plus court chemin à partir de la ville (noeud) de départ pour toutes les destinations représentées dans le graphe
     * (tous les autres noeuds).
     * @param depart Ville de départ
     */
    public void calculateShortPath(String depart) throws GraphException {
        checkErrors(depart);
        initializeDistances();
        this.idxDepart = this.nodes.indexOf(depart);
        this.distances[this.idxDepart] = 0f;
        while(this.nodesDone.size() != this.nodes.size()){
            int idxNodeWithMinDistance = this.findIndexOfNodeWithLessDistance();
            // On a trouvé l'index du noeud ayant la plus faible distance, on peut alors la supprimer de la file :
            this.nodesDone.add(idxNodeWithMinDistance);
            // Récupération des voisins du noeud courant :
            List<Integer> idxNeighbours = this.getNeighboursOfCurrentNode(idxNodeWithMinDistance);
            // Mise à jour des distances des voisins :
            this.updateDistances(idxNeighbours, idxNodeWithMinDistance);
        }
    }// calculateShortPath()

    /**
     * Cette fonction permet de récupérer le plus court chemin entre le noeud
     * de départ qui a été passé à la fonction {@see calculateShortPath} et
     * le noeud destinataire passé en paramètre.
     * @param destination Noeud destinataire / Ville destinataire
     * @return résultats (path => Les villes à traverser, distance => la distance parcourue)
     */
    public Map<String, String> getShortDistanceTo(String destination) {
        Map<String, String> results = new HashMap<>();
        final int indexDestination = this.nodes.indexOf(destination);
        int currentIndex = indexDestination;
        StringBuilder sbPath = new StringBuilder();
        List<Integer> indexesFromEndToStart = new ArrayList<>();
        while(currentIndex != this.idxDepart){
            indexesFromEndToStart.add(currentIndex);
            currentIndex = this.previous[currentIndex];
        }
        indexesFromEndToStart.add(currentIndex);
        Collections.reverse(indexesFromEndToStart); // On inverse tout pour avoir les indices du départ vers l'arrivée
        indexesFromEndToStart.forEach(idx -> {
            sbPath.append(this.nodes.get(idx));
            sbPath.append(separatorCities);
        });
        String path = sbPath.toString();
        results.put("path", path.substring(0, path.length()-separatorCities.length()));
        results.put("distance", String.valueOf(this.distances[indexDestination]));
        return results;
    }// getShortDistanceTo()

    /**
     * Initialise les distances cumulées à +infini.
     */
    private void initializeDistances() {
        for(int i = 0; i < nodes.size(); ++i){
            this.distances[i] = Float.MAX_VALUE;
        }
    }// initializeDistances()

    /**
     * Contrôle les erreurs liés aux données initialisées et passées en paramètre.
     * @param depart Nom du noeud de départ
     * @throws GraphException
     */
    private void checkErrors(String depart) throws GraphException{
        if(StringUtils.isEmpty(depart)){
            throw new GraphException("Departure is missing");
        }
        if(CollectionUtils.isEmpty(this.nodes)){
            throw new GraphException("Summits are missing");
        }
        if(weights == null){
            throw new GraphException("Weights are missing");
        }
        if(this.weights.length != this.weights[0].length){
            throw new GraphException("Weights must be a square matrix");
        }
        if(this.nodes.size() != this.weights[0].length){
            throw new GraphException("Weights must have the same size than the nodes (summits)");
        }
    }// checkErrors()

    /**
     * Retourne l'indice du noeud le plus petit parmi les
     * distances cumulées.
     * @return indice du noeud le plus petit sinon le premier indice 0
     */
    private int findIndexOfNodeWithLessDistance(){
        int idxNodeWithMinDistance = 0;
        float minDistance = Float.MAX_VALUE;
        for(int i = 0; i < this.distances.length; ++i){
            if(!this.nodesDone.isEmpty() && this.nodesDone.contains(i)){
                continue; // On ne regarde pas les distances des noeuds déjà traités
            }
            if(this.distances[i] < minDistance){
                minDistance = this.distances[i];
                idxNodeWithMinDistance = i;
            }
        }
        return idxNodeWithMinDistance;
    }// findIndexOfNodeWithLessDistance()

    /**
     * Cette fonction récupère les voisins du noeud en cours de traitement.
     * @param idxCurrentNode indice du noeud en cours de traitement.
     * @return Liste d'indices des voisins du noeud en question.
     */
    private List<Integer> getNeighboursOfCurrentNode(int idxCurrentNode){
        List<Integer> idxNeighbours = new ArrayList<>();
        for(int col = 0; col < this.nodes.size(); ++col){
            if(this.nodesDone != null && this.nodesDone.contains(col)){
                continue; // On ne traite pas un voisin déjà traité
            }
            if(this.weights[idxCurrentNode][col] != null && col != idxCurrentNode){
                idxNeighbours.add(col);
            }
        }
        return idxNeighbours;
    }// getNeighboursOfCurrentNode()

    /**
     * Mise à jour des distances cumulées entre le noeud d'origine
     * et les autres noeuds.
     * @param idxNeighbours Indices des voisins du noeud en cours de traitement
     * @param idxCurrentNode Indice du noeud en cours de traitement
     */
    private void updateDistances(List<Integer> idxNeighbours, final int idxCurrentNode){
        idxNeighbours.forEach(idxNeighbour -> {
            if(this.distances[idxNeighbour] > this.weights[idxCurrentNode][idxNeighbour] + this.distances[idxCurrentNode]){
                this.distances[idxNeighbour] = this.weights[idxCurrentNode][idxNeighbour] + this.distances[idxCurrentNode];
                this.previous[idxNeighbour]  = idxCurrentNode;
            }
        });
    }// updateDistances()

}// Dijkstra

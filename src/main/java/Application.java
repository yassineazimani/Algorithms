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
import exceptions.GraphException;
import graphes.Dijkstra;
import sort.BubbleSort;
import exceptions.ArgException;
import sort.CocktailSort;
import sort.OddEventSort;
import words.FizzBuzz;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        applyBubbleSort();
        applyCocktailSort();
        applyOddEventSort();
        dijkstra();
    }

    private static void applyBubbleSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before Bubble Sort : *** " + list.toString());
        try {
            BubbleSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with Bubble Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After Bubble Sort : *** " + list.toString());
    }// applyBubbleSort()

    private static void applyCocktailSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before Cocktail Sort : *** " + list.toString());
        try {
            CocktailSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with Cocktail Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After Cocktail Sort : *** " + list.toString());
    }// applyCocktailSort()

    private static void applyOddEventSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before OddEvent Sort : *** " + list.toString());
        try {
            OddEventSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with OddEvent Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After OddEvent Sort : *** " + list.toString());
    }// applyOddEventSort()

    private static void dijkstra(){
        System.out.println("*** Short path (Dijkstra) ***");
        final Float[][] distances = {{0f, 3f, 2.8f, 1f, 0.5f, null, null, null, null, null, null},
                {3f, 0f, null, null, null, null, null, 1.5f, 2.3f, null, null},
                {2.8f, null, 0f, null, null, null, null, null, null, 3f, 3.1f},
                {1f, null, null, 0f, 0.1f, 9.2f, 11f, null, null, null, null},
                {0.5f, null, null, 0.1f, 0f, 4.8f, null, null, null, null, null},
                {null, null, null, 9.2f, 4.8f, 0f, null, null, null, null, null},
                {null, null, null, 11f, null, null, 0f, 3.88f, null, null, null},
                {null, 1.5f, null, null, null, null, 3.88f, 0f, null, null, null},
                {null, 2.3f, null, null, null, null, null, null, 0f, 10.2f, null},
                {null, null, 3f, null, null, null, null, null, 10.2f, 0f, 2.2f},
                {null, null, 3.1f, null, null, null, null, null, null, 2.2f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet", "Les Angles", "Villeneuve-lès-Avignon", "Pujaut", "Aramon", "Barbentane", "Châteaurenard", "Montfavet", "Morières-lès-Avignon"};
        Dijkstra dijkstra = new Dijkstra(distances, villes);
        try {
            dijkstra.calculateShortPath(villes[0]); // calcul à partir d'Avignon vers toutes les autres villes de l'agglomération
            System.out.println("Avignon -> Others cities");
            for(String ville : villes){
                Map<String, String> detailsPath = dijkstra.getShortDistanceTo(ville);
                System.out.println("Itinerary " + villes[0] + " to " + ville + " : " + detailsPath.get("path"));
                System.out.println("Distance " + villes[0] + " to " + ville + " : " + detailsPath.get("distance") + "km");
                System.out.println();
            }

            dijkstra.reinit(distances, villes);
            dijkstra.calculateShortPath(villes[6]); // calcul à partir d'Aramon vers toutes les autres villes de l'agglomération
            System.out.println("Aramon -> Others cities");
            for(String ville : villes){
                Map<String, String> detailsPath = dijkstra.getShortDistanceTo(ville);
                System.out.println("Itinerary " + villes[6] + " to " + ville + " : " + detailsPath.get("path"));
                System.out.println("Distance " + villes[6] + " to " + ville + " : " + detailsPath.get("distance") + "km");
                System.out.println();
            }

            dijkstra.reinit(distances, villes);
            dijkstra.calculateShortPath(villes[9]); // calcul à partir de Montfavet vers toutes les autres villes de l'agglomération
            System.out.println("Montfavet -> Others cities");
            for(String ville : villes){
                Map<String, String> detailsPath = dijkstra.getShortDistanceTo(ville);
                System.out.println("Itinerary " + villes[9] + " to " + ville + " : " + detailsPath.get("path"));
                System.out.println("Distance " + villes[9] + " to " + ville + " : " + detailsPath.get("distance") + "km");
                System.out.println();
            }
            System.out.println("*** End Short path (Dijkstra) ***");
        }catch(GraphException ge){
            ge.printStackTrace();
        }
    }// dijkstra()

}// Application

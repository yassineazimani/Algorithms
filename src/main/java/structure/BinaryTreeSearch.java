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
package structure;

import java.util.Optional;

/**
 * Représente un arbre
 * @param <T>
 */
public class BinaryTreeSearch<T extends Comparable> {

    /**
     * Valeur courante du noeud
     */
    private T value;

    /**
     * Noeud gauche du noeud courant.
     */
    private BinaryTreeSearch<T> nodeLeft;

    /**
     * Noeud droite du noeud courant
     */
    private BinaryTreeSearch<T> nodeRight;

    /**
     * Constructeur par défaut
     */
    public BinaryTreeSearch() {}// Tree()

    /**
     * Constructeur par copie
     * @param value Valeur de la racine de l'arbre
     */
    public BinaryTreeSearch(T value) {
        this.value = value;
    }// Tree()

    /**
     * Indique si l'arbre est vide.
     * @return boolean
     */
    public boolean isEmpty(){
        return this.value == null;
    }// isEmpty()

    /**
     * Ajoute une valeur dans l'arbre.
     * @param value Valeur à ajouter
     */
    public void addNode(T value) {
        if(this.value == null){
            this.value = value;
        }else{
            addNodeToChildNode(value);
        }
    }// addNode()

    /**
     * Cherche la valeur la plus petite de l'arbre
     * @return valeur
     */
    public T searchMin() {
        T min = this.value;
        BinaryTreeSearch<T> cursor = this;
        while(cursor != null){
            min = cursor.getValue();
            cursor = cursor.getNodeLeft();
        }
        return min;
    }// searchMin()

    /**
     * Cherche la valeur la plus grande de l'arbre
     * @return valeur
     */
    public T searchMax() {
        T max = this.value;
        BinaryTreeSearch<T> cursor = this;
        while(cursor != null){
            max = cursor.getValue();
            cursor = cursor.getNodeRight();
        }
        return max;
    }// searchMax()

    /**
     * Recherche une valeur dans l'arbre courant
     * @param value valeur à rechercher
     * @return noeud contenant la valeur recherchée
     */
    public Optional<BinaryTreeSearch<T>> search(T value){
        return this.search(value, this);
    }// search()

    /**
     * Récupération de la hauteur d'un arbre
     * @return hauteur d'un arbre
     */
    public int getHeight(){
        return this.getHeight(this);
    }// getHeight()

    /**
     * Affichage l'arbre avec un parcours prefixe
     */
    public void printParcoursPreFixe() {
        System.out.print(this.getValue() + " ");
        if (this.getNodeLeft() != null) {
            this.getNodeLeft().printParcoursPreFixe();
        }
        if (this.getNodeRight() != null) {
            this.getNodeRight().printParcoursPreFixe();
        }
    }// printParcoursPreFixe()

    /**
     * Affichage l'arbre avec un parcours infixe
     */
    public void printParcoursInFixe() {
        if (this.getNodeLeft() != null) {
            this.getNodeLeft().printParcoursInFixe();
        }
        System.out.print(this.getValue() + " ");
        if (this.getNodeRight() != null) {
            this.getNodeRight().printParcoursInFixe();
        }
    }// printParcoursInFixe()

    /**
     * Affichage de l'arbre avec un parcours postfixe
     */
    public void printParcoursPostFixe() {
        if (this.getNodeLeft() != null) {
            this.getNodeLeft().printParcoursPostFixe();
        }
        if (this.getNodeRight() != null) {
            this.getNodeRight().printParcoursPostFixe();
        }
        System.out.print(this.getValue() + " ");
    }// printParcoursPostFixe()

    /**
     * Récupération de la valeur courante de l'arbre
     * @return valeur
     */
    public T getValue() {
        return value;
    }// getValue()

    /**
     * Récupération du noeud gauche de l'arbre
     * @return noeud
     */
    public BinaryTreeSearch<T> getNodeLeft() {
        return nodeLeft;
    }// getNodeLeft()

    /**
     * Récupération du noeud droit de l'arbre
     * @return noeud
     */
    public BinaryTreeSearch<T> getNodeRight() {
        return nodeRight;
    }// getNodeRight()

    private void addNodeToChildNode(T value){
        if(this.value != null && this.value.equals(value)){
            return; // Pas de valeurs dupliquées
        }
        if(value.compareTo(this.value) < 0){
            if(nodeLeft != null){
                nodeLeft.addNode(value);
            }else{
                this.nodeLeft = new BinaryTreeSearch<>(value);
            }
        }else{
            if(nodeRight != null){
                nodeRight.addNode(value);
            }else{
                this.nodeRight = new BinaryTreeSearch<>(value);
            }
        }
    }// addNodeToChildNode()

    private Optional<BinaryTreeSearch<T>> search(T value, BinaryTreeSearch<T> node){
        BinaryTreeSearch<T> result = null;
        BinaryTreeSearch<T> cursor = node;
        if(cursor != null && cursor.getValue() != null) {
            if (value.compareTo(cursor.getValue()) < 0) {
                return search(value, cursor.getNodeLeft());
            } else if (value.compareTo(cursor.getValue()) > 0) {
                return search(value, cursor.getNodeRight());
            } else {
                return Optional.of(cursor);
            }
        }
        return Optional.ofNullable(result);
    }// search()

    /**
     * Récupération de la hauteur d'un arbre
     * @return hauteur d'un arbre
     */
    private int getHeight(BinaryTreeSearch<T> node) {
        return node == null ? 0 : (1 + Math.max(this.getHeight(node.getNodeLeft()), this.getHeight(node.getNodeRight())));
    }// getHeight()

}// Tree

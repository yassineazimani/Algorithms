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

import exceptions.IndexOutOfRangeException;

/**
 * Liste simplement chaînée
 */
public class SimpleList<T> {

    /**
     * Maillon de tête de la liste.
     */
    private SimpleLink<T> head;

    /**
     * Construction d'une liste chaînée.
     */
    public SimpleList() {
        this.head = null;
    }// SimpleList()

    /**
     * Indique si la liste est vide.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.head == null;
    }// isEmpty()

    /**
     * Ajoute une valeur dans la liste chaînée.
     *
     * @param value Valeur
     */
    public void add(T value) {
        if (this.head == null) {
            this.head = new SimpleLink(0, value, null);
        } else {
            SimpleLink cursor = this.head;
            for (; cursor.getNextLink() != null; cursor = cursor.getNextLink()) {
            }
            cursor.setNextLink(new SimpleLink(cursor.getIndex() + 1, value, null));
        }
    }// add()

    /**
     * Récupération d'une valeur à l'indice passé en paramètre
     *
     * @param idx indice
     * @return valeur
     * @throws IndexOutOfRangeException Si l'index n'existe pas, l'exception est levée
     */
    public T get(int idx) throws IndexOutOfRangeException {
        SimpleLink cursor = this.head;
        if (cursor == null) {
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
        for (; cursor.getNextLink() != null; cursor = cursor.getNextLink()) {
            if (cursor.getIndex() == idx) {
                return (T) cursor.getValue();
            }
        }
        return (T) cursor.getValue();
    }// get()

    /**
     * Ajoute une valeur à l'indice passé en paramètre
     *
     * @param idx   indice où placer la valeur
     * @param value valeur à ajouter
     */
    public void add(int idx, T value) throws IndexOutOfRangeException {
        SimpleLink cursor = this.head;
        if (cursor == null) {
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
        boolean incrementIdx = false;
        for (SimpleLink previousCursor = null; cursor.getNextLink() != null; previousCursor = cursor, cursor = cursor.getNextLink()) {
            if (cursor.getIndex() == idx) {
                addLinkAtIndex(previousCursor, cursor, idx, value);
                incrementIdx = true;
            }
            if(incrementIdx){
                // Décallage des indexs de tous les autres éléments après le récent ajout.
                cursor.setIndex(cursor.getIndex() + 1);
            }
        }
        if(!incrementIdx) {
            // Si aucun décallage d'index n'a été réalisé, c'est que l'index en question n'a jamais été trouvé.
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
    }// add()

    /**
     * Supprime une valeur située à l'index passé en paramètre
     * @param idx index où la valeur à supprimer se trouve
     * @throws IndexOutOfRangeException Si l'index n'existe pas, l'exception est levée
     */
    public void remove(int idx) throws IndexOutOfRangeException {
        SimpleLink cursor = this.head;
        if (cursor == null) {
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
        boolean decrementIdx = false;
        for (; cursor.getNextLink() != null; cursor = cursor.getNextLink()) {
            if (cursor.getIndex() == idx) {
                if(idx == 0){
                    this.head = cursor.getNextLink();
                }
                decrementIdx = true;
            }
            if(decrementIdx){
                cursor.setIndex(cursor.getIndex() - 1);
            }
        }
        if(!decrementIdx) {
            // Si aucun décallage d'index n'a été réalisé, c'est que l'index en question n'a jamais été trouvé.
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
    }// remove()

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        SimpleLink cursor = this.head;
        if(cursor != null) {
            while (cursor.getNextLink() != null) {
                sb.append(cursor.getValue());
                sb.append(", ");
                cursor = cursor.getNextLink();
            }
            sb.append(cursor.getValue());
        }
        sb.append("]");
        return sb.toString();
    }// toString()

    /**
     * Retourne l'index de la valeur à rechercher dans une liste.
     * @param value Valeur à rechercher
     * @return -1 si la valeur n'existe pas dans la liste sinon l'index qui possède la valeur.
     */
    public int indexOf(T value) {
        SimpleLink cursor = this.head;
        if(cursor == null) {
            return -1;
        }
        while (cursor.getNextLink() != null) {
            if(cursor.getValue().equals(value)){
                return cursor.getIndex();
            }
            cursor = cursor.getNextLink();
        }
        return cursor.getValue().equals(value) ? cursor.getIndex() : -1;
    }// indexOf()

    /**
     * Indique si la valeur passée en paramètre existe dans la liste chaînée.
     * @param value Valeur à rechercher
     * @return boolean
     */
    public boolean contains(T value){
        SimpleLink cursor = this.head;
        if(cursor == null) {
            return false;
        }
        while (cursor.getNextLink() != null) {
            if(cursor.getValue().equals(value)){
                return true;
            }
            cursor = cursor.getNextLink();
        }
        return cursor.getValue().equals(value);
    }// contains()

    private void addLinkAtIndex(SimpleLink<T> previousCursor, SimpleLink<T> currentCursor, int idx, T value){
        SimpleLink newLink = new SimpleLink(idx, value, currentCursor);
        if(previousCursor != null){
            previousCursor.setNextLink(newLink);
        }
        if(idx == 0){
            this.head = newLink; // Si l'ajout se fait en tête, remplacement de la tête
        }
    }// addLinkAtIndex()

}// SimpleList

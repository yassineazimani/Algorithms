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
 * Liste circulaire chaînée
 */
public class CircularList<T> {

    /**
     * Maillon de tête de la liste.
     */
    private DoubleLink<T> head;

    /**
     * Construction d'une liste chaînée.
     */
    public CircularList() {
        this.head = null;
    }// DoubleList()

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
            this.head = new DoubleLink<>(0, value, null, null);
        } else {
            DoubleLink cursor = this.head;
            for (; cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head); cursor = cursor.getNextLink()) { }
            cursor.setNextLink(new DoubleLink(cursor.getIndex() + 1, value, cursor, this.head));
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
        DoubleLink cursor = this.head;
        if (cursor == null) {
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
        for (; cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head); cursor = cursor.getNextLink()) {
            if (cursor.getIndex() == idx) {
                return (T) cursor.getValue();
            }
        }
        return (T) cursor.getValue();
    }// get()

    /**
     * Supprime une valeur située à l'index passé en paramètre
     * @param idx index où la valeur à supprimer se trouve
     * @throws IndexOutOfRangeException Si l'index n'existe pas, l'exception est levée
     */
    public void remove(int idx) throws IndexOutOfRangeException {
        DoubleLink cursor = this.head;
        if (cursor == null) {
            throw new IndexOutOfRangeException("Index out of range, idx = " + idx);
        }
        boolean decrementIdx = false;
        for (; cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head); cursor = cursor.getNextLink()) {
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
        DoubleLink cursor = this.head;
        if(cursor != null) {
            while (cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head)) {
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
        DoubleLink cursor = this.head;
        if(cursor == null) {
            return -1;
        }
        while (cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head)) {
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
        DoubleLink cursor = this.head;
        if(cursor == null) {
            return false;
        }
        while (cursor.getNextLink() != null && !cursor.getNextLink().equals(this.head)) {
            if(cursor.getValue().equals(value)){
                return true;
            }
            cursor = cursor.getNextLink();
        }
        return cursor.getValue().equals(value);
    }// contains()

}// CircularList

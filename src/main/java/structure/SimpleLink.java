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

/**
 * Classe représentant un maillon utilisé pour
 * l'implémentation d'une liste chaînée.
 */
public class SimpleLink<T> {

    /**
     * Position du maillon courant dans la liste
     */
    private int index;

    /**
     * Valeur du maillon courant
     */
    private T value;

    /**
     * Prochain maillon
     */
    private SimpleLink<T> nextLink;

    /**
     * Constructeur
     * @param index Position du maillon courant dans la liste
     * @param value Valeur du maillon courant
     * @param nextLink Prochain maillon
     */
    public SimpleLink(int index, T value, SimpleLink<T> nextLink) {
        this.index = index;
        this.value = value;
        this.nextLink = nextLink;
    }// SimpleLink()

    public int getIndex() {
        return index;
    }// getIndex()

    public void setIndex(int index) {
        this.index = index;
    }// setIndex()

    public T getValue() {
        return value;
    }// getValue()

    public SimpleLink<T> getNextLink() {
        return nextLink;
    }// getNextLink()

    public void setNextLink(SimpleLink<T> nextLink) {
        this.nextLink = nextLink;
    }// setNextLink()

}// SimpleLink

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

import java.util.Objects;

/**
 * Classe représentant un maillon doublement chaîné utilisé pour
 * l'implémentation d'une liste chaînée.
 */
public class DoubleLink<T> {

    /**
     * Position du maillon courant dans la liste
     */
    private int index;

    /**
     * Valeur du maillon courant
     */
    private T value;

    /**
     * Précédent maillon
     */
    private DoubleLink<T> prevLink;

    /**
     * Prochain maillon
     */
    private DoubleLink<T> nextLink;

    /**
     * Constructeur
     *
     * @param index    Position du maillon courant dans la liste
     * @param value    Valeur du maillon courant
     * @param prevLink Précédent maillon
     * @param nextLink Prochain maillon
     */
    public DoubleLink(int index, T value, DoubleLink<T> prevLink, DoubleLink<T> nextLink) {
        this.index = index;
        this.value = value;
        this.prevLink = prevLink;
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

    public DoubleLink<T> getNextLink() {
        return nextLink;
    }// getNextLink()

    public void setNextLink(DoubleLink<T> nextLink) {
        this.nextLink = nextLink;
    }// setNextLink()

    public DoubleLink<T> getPrevLink() { return prevLink; }// getPrevLink()

    public void setPrevLink(DoubleLink<T> prevLink) { this.prevLink = prevLink; }// setPrevLink()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLink<?> that = (DoubleLink<?>) o;
        return index == that.index &&
                Objects.equals(value, that.value) &&
                Objects.equals(prevLink, that.prevLink) &&
                Objects.equals(nextLink, that.nextLink);
    }// equals()

    @Override
    public int hashCode() {
        return Objects.hash(index, value, prevLink, nextLink);
    }// hashCode()

}// DoubleLink

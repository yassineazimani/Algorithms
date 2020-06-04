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
package sort;

import exceptions.ArgException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * Tri par fusion
     * @param list liste à trier
     */
    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException{
        if (CollectionUtils.isEmpty(list)) {
            throw new ArgException("List to sort is missing");
        }
        mergeSort(list, 0, list.size()-1);
    }// sort()

    /**
     * Fonction récursive découpant la liste en sous-listes jusqu'à se retrouver avec des valeurs solitaires
     * puis fusion des valeurs solitaires / des sous-listes jusqu'à se retrouver avec la liste d'origine
     * triée.
     * @param list Liste
     * @param idxStart index de début
     * @param idxEnd index de fin
     */
    private static <T extends Comparable<T>> void mergeSort(List<T> list, int idxStart, int idxEnd){
        if(idxStart < idxEnd && idxEnd - idxStart >= 1){
            int idxMiddle = (idxStart + idxEnd) / 2;
            mergeSort(list, idxStart, idxMiddle);
            mergeSort(list, idxMiddle+1, idxEnd);
            merge(list, idxStart, idxMiddle, idxEnd);
        }
    }// mergeSort()

    /**
     * Fusion de deux valeurs / sous-listes en une seule liste (fusion sur place)
     * @param list liste à trier
     * @param idxStart index de début de la première sous-liste
     * @param idxMiddle index de début de la seconde sous-liste
     * @param idxEnd index de fin de la seconde sous-liste
     */
    private static <T extends Comparable<T>> void merge(List<T> list, int idxStart, int idxMiddle, int idxEnd) {
        List<T> listMerged = new ArrayList<>();
        int idxLeft = idxStart; // Index de début de la première sous-liste qui va évoluer en fonction du parcours de la sous-liste
        int idxRight = idxMiddle + 1; // Index de début de la seconde sous-liste qui va évoluer en fonction du parcours de la sous-liste

        // Parcours des 2 sous-tableaux en même temps, même s'ils n'ont pas la même dimension :
        while(idxLeft <= idxMiddle && idxRight <= idxEnd){
            if(list.get(idxLeft).compareTo(list.get(idxRight)) <= 0){
                listMerged.add(list.get(idxLeft));
                ++idxLeft;
            }else{
                listMerged.add(list.get(idxRight));
                ++idxRight;
            }
        }

        // Il est possible d'avoir une sous-liste encore remplie et une autre sous-liste vide, d'où le parcours suivant :
        // Première sous-liste encore remplie :
        while(idxLeft <= idxMiddle){
            listMerged.add(list.get(idxLeft));
            ++idxLeft;
        }

        // Deuxième sous-liste encore remplie :
        while(idxRight <= idxEnd){
            listMerged.add(list.get(idxRight));
            ++idxRight;
        }

        // On remplace les valeurs non triées de la liste d'origine en fonction de la liste triée fusionnée :
        for(int i = 0, idxMerged = idxStart; i < listMerged.size(); ++i, ++idxMerged){
            list.set(idxMerged, listMerged.get(i));
        }
    }// merge()

}// MergeSort

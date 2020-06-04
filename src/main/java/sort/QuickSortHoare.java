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

import java.util.Collections;
import java.util.List;

public class QuickSortHoare {

    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException {
        if (CollectionUtils.isEmpty(list)) {
            throw new ArgException("List to sort is missing");
        }
        sort(list, 0, list.size()-1);
    }// sort()

    private static <T extends Comparable<T>> void sort(List<T> list, int idxStart, int idxEnd) {
        if(idxStart < idxEnd){
            int partitionIdx = partition(list, idxStart, idxEnd);
            sort(list, idxStart, partitionIdx); // thread possible
            sort(list, partitionIdx+1, idxEnd); // thread possible
        }
    }// sort()

    /**
     * Cette fonction de partition permet de positionner les éléments en fonction du pivot
     * de l'algorithme. Ici, c'est l'algorithme originel Hoare qui est utilisé pour le partionnement.
     * Le pivot est le premier élément de la liste, et on parcourt de gauche vers la droite ainsi
     * que de la droite vers la gauche la (sous-)liste en incrémentant et décrémentant les indexs,
     * jusqu'à qu'ils se chevauchent. Lorsqu'ils se chevauchent, l'index qui décrémentait devient
     * futur pivot et est retourné par la fonction.
     * @param list (sous-)liste à partionner
     * @param idxStart indice du début de la (sous-)liste
     * @param idxEnd indice de la fin de la (sous-)liste
     * @return futur pivot
     */
    private static <T extends Comparable<T>> int partition(List<T> list, int idxStart, int idxEnd){
        T pivot = list.get(idxStart);
        int i = idxStart - 1;
        int j = idxEnd + 1;
        while(true) {
            do {
                ++i;
            } while (list.get(i).compareTo(pivot) < 0);
            do {
                --j;
            } while (list.get(j).compareTo(pivot) > 0);
            if (i >= j) {
                return j;
            }
            Collections.swap(list, i, j);
        }
    }// partition()

}// QuickSortHoare

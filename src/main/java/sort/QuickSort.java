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

public class QuickSort {

    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException {
        if (CollectionUtils.isEmpty(list)) {
            throw new ArgException("List to sort is missing");
        }
        sort(list, 0, list.size()-1);
    }// sort()

    private static <T extends Comparable<T>> void sort(List<T> list, int idxStart, int idxEnd) {
        if(idxStart < idxEnd){
            int partitionIdx = partition(list, idxStart, idxEnd);
            sort(list, idxStart, partitionIdx-1); // thread possible
            sort(list, partitionIdx+1, idxEnd); // thread possible
        }
    }// sort()

    /**
     * Cette fonction de partition permet de positionner les éléments en fonction du pivot
     * de l'algorithme. Ici, c'est l'algorithme Lomuto qui est utilisé pour le partionnement.
     * Le pivot est le dernier élément de la liste, et on positionne les éléments supérieurs
     * au pivot après ce dernier et les éléments inférieurs au pivot avant ce dernier.
     * @param list (sous-)liste à partionner
     * @param idxStart indice du début de la (sous-)liste
     * @param idxEnd indice de la fin de la (sous-)liste
     * @return futur pivot
     */
    private static <T extends Comparable<T>> int partition(List<T> list, int idxStart, int idxEnd){
        T pivot = list.get(idxEnd); // On prend le dernier élément de la liste en guise de pivot
        int i = idxStart;
        for(int j = idxStart; j < idxEnd; ++j){
            if(list.get(j).compareTo(pivot) <= 0){ // L(j) <= pivot
                Collections.swap(list, i, j);
                ++i;
            }
        }
        Collections.swap(list, i, idxEnd);
        return i;
    }// partition()

}// QuickSort

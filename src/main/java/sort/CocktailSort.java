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

import java.util.List;

import static java.util.Collections.swap;

public class CocktailSort {

    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException {
        if(CollectionUtils.isEmpty(list)){
            throw new ArgException("List to sort is missing");
        }
        int idxStart = 0, idxEnd = list.size() - 2; // pas -1 car le dernier élément aura déjà été trié
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            isSorted = forwardSortBubble(list, idxStart, isSorted);
            isSorted = reverseSortBubble(list, idxStart, idxEnd, isSorted);
            idxStart = idxStart + 1;
            idxEnd = idxEnd - 1;
        }
    }// sort()

    private static <T extends Comparable<T>> boolean forwardSortBubble(List<T> list, int idxStart, boolean isSorted){
        for (int i = idxStart; i < list.size()-1; ++i) {
            int cmp = list.get(i).compareTo(list.get(i+1));
            if (cmp > 0) {
                swap(list, i, i + 1);
                isSorted = false;
            }
        }
        return isSorted;
    }// forwardSortBubble()

    private static <T extends Comparable<T>> boolean reverseSortBubble(List<T> list, int idxStart, int idxEnd, boolean isSorted){
        for (int j = idxEnd; j > idxStart; --j) {
            int cmp = list.get(j-1).compareTo(list.get(j));
            if (cmp > 0) {
                swap(list, j, j - 1);
                isSorted = false;
            }
        }
        return isSorted;
    }// reverseSortBubble()

}// CocktailSort

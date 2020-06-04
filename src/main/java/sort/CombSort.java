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

public class CombSort {

    private static final float REDUCTION_FACTOR = 1.3f;

    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException {
        if(CollectionUtils.isEmpty(list)){
            throw new ArgException("List to sort is missing");
        }
        int intervalle = (int) Math.floor(list.size() / REDUCTION_FACTOR);
        if(intervalle < 1){
            intervalle = 1;
        }
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < list.size() - intervalle; ++i){
                int cmp = list.get(i).compareTo(list.get(i+intervalle));
                if(cmp > 0){
                    Collections.swap(list, i, i+intervalle);
                    isSorted = false;
                }
            }
            --intervalle;
        }
    }// sort()

}// CombSort

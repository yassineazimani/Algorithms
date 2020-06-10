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

public class OddEventSort {

    public static <T extends Comparable<T>> void sort(List<T> list) throws ArgException{
        if(CollectionUtils.isEmpty(list)){
            throw new ArgException("List to sort is missing");
        }
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            isSorted = sortPair(list, isSorted);
            isSorted = sortOdd(list, isSorted);
        }
    }// sort()

    private static <T extends Comparable<T>> boolean test(List<T> list, int a, int b, boolean isSorted){
        int cmp = list.get(a).compareTo(list.get(b));
        if(cmp > 0){
            Collections.swap(list, a, b);
            isSorted = false;
        }
        return isSorted;
    }// test()

    private static <T extends Comparable<T>> boolean sortPair(List<T> list, boolean isSorted){
        for(int i = 0; i < list.size()-1; i += 2){
            isSorted = test(list, i, i+1, isSorted);
        }
        return isSorted;
    }// sortPair()

    private static <T extends Comparable<T>> boolean sortOdd(List<T> list, boolean isSorted) {
        for(int j = 1; j < list.size()-1; j += 2){
            isSorted = test(list, j, j+1, isSorted);
        }
        return isSorted;
    }// sortOdd()

}// OddEventSort

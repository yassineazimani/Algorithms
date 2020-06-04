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
import sort.BubbleSort;
import exceptions.ArgException;
import sort.CocktailSort;
import sort.OddEventSort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        applyBubbleSort();
        applyCocktailSort();
        applyOddEventSort();
    }

    private static void applyBubbleSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before Bubble Sort : *** " + list.toString());
        try {
            BubbleSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with Bubble Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After Bubble Sort : *** " + list.toString());
    }// applyBubbleSort()

    private static void applyCocktailSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before Cocktail Sort : *** " + list.toString());
        try {
            CocktailSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with Cocktail Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After Cocktail Sort : *** " + list.toString());
    }// applyCocktailSort()

    private static void applyOddEventSort(){
        List<Integer> list = Stream.of(5, 1, 4, 2, 8, 0, 2).collect(Collectors.toList());
        System.out.println("*** Before OddEvent Sort : *** " + list.toString());
        try {
            OddEventSort.sort(list);
        }catch(ArgException e){
            System.err.println("Impossible to sort list with OddEvent Sort, reason : " + e.getMessage());
        }
        System.out.println("*** After OddEvent Sort : *** " + list.toString());
    }// applyOddEventSort()

}// Application

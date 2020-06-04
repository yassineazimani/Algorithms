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
package words;

public class FizzBuzz {

    /**
     * Génère la chaîne de caractères FizzBuzz entre les nombres min et max.
     * @param min Nombre de l'intervalle minimum
     * @param max Nombre de l'intervalle maximum
     * @return Chaîne de caractères FizzBuzz
     */
    public static String generate(int min, int max) {
        StringBuilder sb = new StringBuilder();
        for(int i = min; i <= max; ++i){
            sb.append(evaluateNumber(i));
        }
        return sb.toString();
    }// generate()

    /**
     * Evalue le nombre courant
     * @param i nombre courant
     * @return nombre transformé en chaîne de caractères
     */
    private static String evaluateNumber(int i){
        if(i % 3 == 0 && i % 5 == 0){
            return "Fizzbuzz";
        }
        if(i % 3 == 0){
            return "Fizz";
        }
        if(i % 5 == 0){
            return "Buzz";
        }
        return String.valueOf(i);
    }// evaluateNumber()

}// FizzBuzz

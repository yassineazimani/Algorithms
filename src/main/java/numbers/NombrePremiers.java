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
package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe possédant des fonctionnalités permettant
 * de gérer les nombres premiers.
 */
public class NombrePremiers {

    /**
     * Génération de l'ensemble des nombres premiers.
     *
     * @param max Recherche des nombres premiers jusqu'au nombre max.
     * @return nombres premiers
     */
    public static List<Integer> getNombrePremiers(int max) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < max; ++i) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }// getNombrePremiers()

    /**
     * Vérifie que le nombre i est un nombre premier.
     *
     * @param i Nombre à tester
     * @return boolean
     */
    private static boolean isPrime(int i) {
        boolean isPrime = true;
        for (int j = 2; j < i; ++j) {
            if (i % j == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }// isPrime()

}// NombrePremiers

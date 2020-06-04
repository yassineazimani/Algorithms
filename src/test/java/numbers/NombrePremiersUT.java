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

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class NombrePremiersUT {

    private final int maxSearch = 1000;

    @Test
    public void zero_shouldnt_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(0)).isFalse();
    }// zero_shouldnt_be_prime_number()

    @Test
    public void one_shouldnt_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(1)).isFalse();
    }// one_shouldnt_be_prime_number()

    @Test
    public void two_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(2)).isTrue();
    }// two_should_be_prime_number()

    @Test
    public void three_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(3)).isTrue();
    }// three_should_be_prime_number()

    @Test
    public void four_shouldnt_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(4)).isFalse();
    }// four_shouldnt_be_prime_number()

    @Test
    public void five_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(5)).isTrue();
    }// five_should_be_prime_number()

    // Corsons un peu plus les tests maintenant, on ne se préoccupe pas de l'ordre, je veux juste
    // savoir si 11 fait parti des résultats
    @Test
    public void eleven_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(11)).isTrue();
    }// eleven_should_be_prime_number()

    // Parfait, tous les tests passent... Essayons de rajouter un autre nombre premier :
    @Test
    public void two_hundred_eighty_one_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(281)).isTrue();
    }// two_hundred_eighty_one_should_be_prime_number()

    @Test
    public void ninety_seven_should_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(97)).isTrue();
    }// ninety_seven_should_be_prime_number()

    @Test
    public void seventy_shouldnt_be_prime_number(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(maxSearch);
        Assertions.assertThat(nbPremiers).isNotNull();
        Assertions.assertThat(nbPremiers).isNotEmpty();
        Assertions.assertThat(nbPremiers.contains(70)).isFalse();
    }// seventy_shouldnt_be_prime_number()

    @Test
    public void prime_numbers_should_be_sorted(){
        List<Integer> nbPremiers = NombrePremiers.getNombrePremiers(14);
        List<Integer> nbExpected = new ArrayList<Integer>();
        nbExpected.add(2); nbExpected.add(3); nbExpected.add(5); nbExpected.add(7);
        nbExpected.add(11); nbExpected.add(13);
        Assertions.assertThat(nbPremiers.size()).isEqualTo(nbExpected.size());
        for(int i = 0; i < nbPremiers.size(); ++i){
            Assertions.assertThat(nbPremiers.get(i)).isEqualTo(nbExpected.get(i));
        }
    }// prime_numbers_should_be_sorted()

}// NombrePremiersUT

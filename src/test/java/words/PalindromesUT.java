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

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.charset.StandardCharsets;

/**
 * https://fr.wikipedia.org/wiki/Liste_de_palindromes_fran%C3%A7ais
 */
@RunWith(JUnit4.class)
public class PalindromesUT {

    @Test
    public void null_string_shouldnt_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome(null)).isFalse();
    }// null_string_shouldnt_be_palindrome

    @Test
    public void empty_string_shouldnt_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("")).isFalse();
    }// empty_string_shouldnt_be_palindrome

    @Test
    public void a_shouldnt_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("a")).isFalse();
    }// a_shouldnt_be_palindrome

    @Test
    public void aa_should_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("aa")).isTrue();
    }// aa_should_be_palindrome

    @Test
    public void bb_should_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("bb")).isTrue();
    }// bb_should_be_palindrome

    @Test
    public void oui_shouldnt_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("oui")).isFalse();
    }// oui_shouldnt_be_palindrome

    @Test
    public void non_should_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("non")).isTrue();
    }// non_should_be_palindrome

    @Test
    public void kayak_should_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("kayak")).isTrue();
    }// kayak_should_be_palindrome

    @Test
    public void snobons_should_be_palindrome(){
        Assertions.assertThat(Palindromes.isPalindrome("snobons")).isTrue();
    }// snobons_should_be_palindrome()

    @Test
    public void taggât_should_be_palindrome(){
        String word = new String("taggât".getBytes(), StandardCharsets.UTF_8);
        Assertions.assertThat(Palindromes.isPalindrome(word)).isTrue();
    }// taggât()

}// PalindromesUT

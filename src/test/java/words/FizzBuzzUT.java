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

import exceptions.ArgException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FizzBuzzUT {

    @Test
    public void fizz_buzz_with_1_should_return_1() throws ArgException {
        String result = FizzBuzz.generate(1, 1);
        Assertions.assertThat(result).isEqualTo("1");
    }// fizz_buzz_with_1_should_return_1()

    @Test
    public void fizz_buzz_with_2_should_return_2() throws ArgException {
        String result = FizzBuzz.generate(2, 2);
        Assertions.assertThat(result).isEqualTo("2");
    }// fizz_buzz_with_2_should_return_2()

    @Test
    public void fizz_buzz_with_3_should_return_Fizz() throws ArgException {
        String result = FizzBuzz.generate(3, 3);
        Assertions.assertThat(result).isEqualTo("Fizz");
    }// fizz_buzz_with_3_should_return_Fizz()

    @Test
    public void fizz_buzz_with_4_should_return_4() throws ArgException {
        String result = FizzBuzz.generate(4, 4);
        Assertions.assertThat(result).isEqualTo("4");
    }// fizz_buzz_with_4_should_return_4()

    @Test
    public void fizz_buzz_with_5_should_return_5() throws ArgException {
        String result = FizzBuzz.generate(5, 5);
        Assertions.assertThat(result).isEqualTo("Buzz");
    }// fizz_buzz_with_4_should_return_4()

    @Test
    public void fizz_buzz_with_6_should_return_Fizz() throws ArgException {
        String result = FizzBuzz.generate(6, 6);
        Assertions.assertThat(result).isEqualTo("Fizz");
    }// fizz_buzz_with_6_should_return_6()

    @Test
    public void fizz_buzz_with_9_should_return_Fizz() throws ArgException {
        String result = FizzBuzz.generate(9, 9);
        Assertions.assertThat(result).isEqualTo("Fizz");
    }// fizz_buzz_with_9_should_return_9()

    @Test
    public void fizz_buzz_with_10_should_return_Buzz() throws ArgException {
        String result = FizzBuzz.generate(10, 10);
        Assertions.assertThat(result).isEqualTo("Buzz");
    }// fizz_buzz_with_10_should_return_Buzz()

    @Test
    public void fizz_buzz_with_20_should_return_Buzz() throws ArgException {
        String result = FizzBuzz.generate(20, 20);
        Assertions.assertThat(result).isEqualTo("Buzz");
    }// fizz_buzz_with_20_should_return_Buzz()

    @Test
    public void fizz_buzz_with_15_should_return_Fizzbuzz() throws ArgException {
        String result = FizzBuzz.generate(15, 15);
        Assertions.assertThat(result).isEqualTo("Fizzbuzz");
    }// fizz_buzz_with_15_should_return_Fizzbuzz()

    @Test
    public void fizz_buzz_with_30_should_return_Fizzbuzz() throws ArgException {
        String result = FizzBuzz.generate(30, 30);
        Assertions.assertThat(result).isEqualTo("Fizzbuzz");
    }// fizz_buzz_with_30_should_return_Fizzbuzz()

    @Test
    public void fizz_buzz_between_1_and_2_should_return_12() throws ArgException {
        String result = FizzBuzz.generate(1, 2);
        Assertions.assertThat(result).isEqualTo("12");
    }// fizz_buzz_between_1_and_2_should_return_12()

    @Test
    public void fizz_buzz_between_1_and_3_should_return_12Fizz() throws ArgException {
        String result = FizzBuzz.generate(1, 2);
        Assertions.assertThat(result).isEqualTo("12");
    }// fizz_buzz_between_1_and_3_should_return_12Fizz()

    @Test
    public void fizz_buzz_between_1_and_6_should_return_12Fizz4BuzzFizzbuzz() throws ArgException {
        String result = FizzBuzz.generate(1, 6);
        Assertions.assertThat(result).isEqualTo("12Fizz4BuzzFizz");
    }// fizz_buzz_between_1_and_6_should_return_12Fizz4BuzzFizzbuzz()

    @Test
    public void fizz_buzz_between_1_and_30_should_return_12Fizz4BuzzFizzbuzz() throws ArgException {
        String result = FizzBuzz.generate(1, 30);
        Assertions.assertThat(result).isEqualTo("12Fizz4BuzzFizz78FizzBuzz11Fizz1314Fizzbuzz1617Fizz19BuzzFizz2223FizzBuzz26Fizz2829Fizzbuzz");
    }// fizz_buzz_between_1_and_30_should_return_12Fizz4BuzzFizzbuzz()

}// FizzBuzzUT

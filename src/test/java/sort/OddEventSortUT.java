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
import models.Personne;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class OddEventSortUT {

    @Test
    public void odd_even_sort_should_throw_arg_exception_when_list_is_null() {
        Assertions.assertThatThrownBy(() -> OddEventSort.sort(null))
                .isInstanceOf(ArgException.class)
                .hasMessage("List to sort is missing");
    }// odd_even_sort_should_throw_arg_exception_when_list_is_null()

    @Test
    public void odd_even_sort_should_throw_arg_exception_when_list_is_empty() {
        Assertions.assertThatThrownBy(() -> OddEventSort.sort(new ArrayList<Integer>()))
                .isInstanceOf(ArgException.class)
                .hasMessage("List to sort is missing");
    }// odd_even_sort_should_throw_arg_exception_when_list_is_empty()

    @Test
    public void odd_even_sort_should_be_equals_to_1() throws ArgException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[1]");
    }// odd_even_sort_should_be_equals_to_1()

    @Test
    public void odd_even_sort_should_be_equals_to_1_2() throws ArgException{
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[1, 2]");
    }// odd_even_sort_should_be_equals_to_1_2()

    @Test
    public void odd_even_sort_should_be_equals_to_1_2_5() throws ArgException {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[1, 2, 5]");
    }// odd_even_sort_should_be_equals_to_1_2_5()

    @Test
    public void odd_even_sort_should_be_equals_to_n85_1_2_5() throws ArgException {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(-85);
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[-85, 1, 2, 5]");
    }// odd_even_sort_should_be_equals_to_n85_1_2_5()

    @Test
    public void odd_even_sort_should_be_equals_to_aa_bb_cc_dd() throws ArgException {
        List<String> list = new ArrayList<>();
        list.add("dd");
        list.add("aa");
        list.add("bb");
        list.add("cc");
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[aa, bb, cc, dd]");
    }// odd_even_sort_should_be_equals_to_aa_bb_cc_dd()

    @Test
    public void odd_even_sort_should_be_equals_to_p10_p50_p70() throws ArgException {
        List<Personne> list = new ArrayList<>();
        list.add(new Personne(50));
        list.add(new Personne(10));
        list.add(new Personne(70));
        OddEventSort.sort(list);
        Assertions.assertThat(list.toString()).isEqualTo("[{10}, {50}, {70}]");
    }// odd_even_sort_should_be_equals_to_p10_p50_p70()
    
}// OddEventSortUT

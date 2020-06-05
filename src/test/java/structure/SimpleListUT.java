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
package structure;

import exceptions.IndexOutOfRangeException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SimpleListUT {

    private SimpleList<Integer> list;

    private SimpleList<String> listStr;

    @Before
    public void setUp(){
        this.list = new SimpleList<>();
        this.listStr = new SimpleList<>();
    }// setUp()

    @Test
    public void simple_list_when_just_initialized_should_be_empty(){
        Assertions.assertThat(this.list.isEmpty()).isTrue();
    }// simple_list_when_just_initialized_should_be_empty()

    @Test
    public void simple_list_when_1_added_shouldnt_be_empty(){
        this.list.add(1);
        Assertions.assertThat(this.list.isEmpty()).isFalse();
    }// simple_list_when_1_added_shouldnt_be_empty()

    @Test
    public void get_list_0_when_1_added_should_return_1() throws IndexOutOfRangeException {
        this.list.add(1);
        Assertions.assertThat(this.list.get(0)).isEqualTo(1);
    }// get_list_0_when_1_added_should_return_1()

    @Test
    public void get_list_0_when_abc_added_should_return_abc() throws IndexOutOfRangeException {
        this.listStr.add("abc");
        Assertions.assertThat(this.listStr.get(0)).isEqualTo("abc");
    }// get_list_0_when_1_added_should_return_1()

    @Test
    public void get_list_0_when_1_2_3_added_should_return_1_2_3() throws IndexOutOfRangeException {
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        for(int i = 1; i < 4; ++i){
            Assertions.assertThat(this.list.get(i-1)).isEqualTo(i);
        }
    }// get_list_0_when_1_added_should_return_1()

    @Test
    public void get_list_0_when_abc_def_ghi_added_should_return_abc_def_ghi() throws IndexOutOfRangeException {
        this.listStr.add("abc");
        this.listStr.add("def");
        this.listStr.add("ghi");
        Assertions.assertThat(this.listStr.get(0)).isEqualTo("abc");
        Assertions.assertThat(this.listStr.get(1)).isEqualTo("def");
        Assertions.assertThat(this.listStr.get(2)).isEqualTo("ghi");
    }// get_list_0_when_abc_def_ghi_added_should_return_abc_def_ghi()

    @Test
    public void get_list_0_when_empty_list_should_throw_index_out_of_range_exception() {
        Assertions.assertThatThrownBy(() -> this.list.get(0))
                .isInstanceOf(IndexOutOfRangeException.class)
                .hasMessage("Index out of range, idx = 0");
    }// get_list_0_when_empty_list_should_throw_index_out_of_range_exception()

    @Test
    public void add_10_at_idx_0_when_list_already_initialized_should_return_10() throws IndexOutOfRangeException {
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        this.list.add(0, 10);
        Assertions.assertThat(this.list.get(0)).isEqualTo(10);
        for(int i = 1; i < 4; ++i){
            Assertions.assertThat(this.list.get(i)).isEqualTo(i);
        }
    }// add_10_at_idx_0_when_list_already_initialized_should_return_10()

    @Test
    public void add_jkl_at_idx_0_when_list_already_initialized_should_return_jkl() throws IndexOutOfRangeException {
        this.listStr.add("abc");
        this.listStr.add("def");
        this.listStr.add("ghi");
        this.listStr.add(0, "jkl");
        Assertions.assertThat(this.listStr.get(0)).isEqualTo("jkl");
        Assertions.assertThat(this.listStr.get(1)).isEqualTo("abc");
        Assertions.assertThat(this.listStr.get(2)).isEqualTo("def");
        Assertions.assertThat(this.listStr.get(3)).isEqualTo("ghi");
    }// get_list_0_when_abc_def_ghi_added_should_return_abc_def_ghi()

    @Test
    public void add_10_at_idx_1_when_list_already_initialized_should_return_10() throws IndexOutOfRangeException {
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        this.list.add(1, 10);
        Assertions.assertThat(this.list.get(0)).isEqualTo(1);
        Assertions.assertThat(this.list.get(1)).isEqualTo(10);
        Assertions.assertThat(this.list.get(2)).isEqualTo(2);
        Assertions.assertThat(this.list.get(3)).isEqualTo(3);
    }// add_10_at_idx_0_when_list_already_initialized_should_return_10()

    @Test
    public void add_10_at_idx_1_when_list_has_only_single_element_should_throw_index_out_of_range_exception() {
        this.list.add(1);
        Assertions.assertThatThrownBy(() -> this.list.add(1, 10))
                .isInstanceOf(IndexOutOfRangeException.class)
                .hasMessage("Index out of range, idx = 1");
    }// add_10_at_idx_1_when_list_has_only_single_element_should_throw_index_out_of_range_exception()

    @Test
    public void remove_element_at_idx_0_when_list_is_empty_should_throw_index_out_of_range_exception() throws IndexOutOfRangeException {
        Assertions.assertThatThrownBy(() -> this.list.remove(0))
                .isInstanceOf(IndexOutOfRangeException.class)
                .hasMessage("Index out of range, idx = 0");
    }// remove_element_at_idx_0_when_list_is_empty_should_throw_index_out_of_range_exception()

    @Test
    public void remove_element_at_idx_1_when_list_already_initialized_should_contains_1_3() throws IndexOutOfRangeException {
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        this.list.remove(1);
        Assertions.assertThat(this.list.get(0)).isEqualTo(1);
        Assertions.assertThat(this.list.get(1)).isEqualTo(3);
    }// remove_element_at_idx_1_when_list_already_initialized_should_contains_1_3()

    @Test
    public void remove_element_at_idx_1_when_list_already_initialized_should_contains_abc_ghi() throws IndexOutOfRangeException {
        this.listStr.add("abc");
        this.listStr.add("def");
        this.listStr.add("ghi");
        this.listStr.remove(1);
        Assertions.assertThat(this.listStr.get(0)).isEqualTo("abc");
        Assertions.assertThat(this.listStr.get(1)).isEqualTo("ghi");
    }// remove_element_at_idx_1_when_list_already_initialized_should_contains_abc_ghi()

    @Test
    public void remove_element_at_idx_0_when_list_already_initialized_should_contains_2_3() throws IndexOutOfRangeException {
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        this.list.remove(0);
        Assertions.assertThat(this.list.get(0)).isEqualTo(2);
        Assertions.assertThat(this.list.get(1)).isEqualTo(3);
    }// remove_element_at_idx_0_when_list_already_initialized_should_contains_2_3()

    @Test
    public void remove_element_at_idx_0_when_list_already_initialized_should_contains_def_ghi() throws IndexOutOfRangeException {
        this.listStr.add("abc");
        this.listStr.add("def");
        this.listStr.add("ghi");
        this.listStr.remove(0);
        Assertions.assertThat(this.listStr.get(0)).isEqualTo("def");
        Assertions.assertThat(this.listStr.get(1)).isEqualTo("ghi");
    }// remove_element_at_idx_0_when_list_already_initialized_should_contains_abc_ghi()

    @Test
    public void index_of_99_when_list_already_initialized_should_return_negative_1(){
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        Assertions.assertThat(this.list.indexOf(99)).isEqualTo(-1);
    }// index_of_99_when_list_already_initialized_should_return_negative_1()

    @Test
    public void index_of_ghi_when_listStr_already_initialized_return_negative_1(){
        this.listStr.add("abc");
        this.listStr.add("def");
        Assertions.assertThat(this.listStr.indexOf("ghi")).isEqualTo(-1);
    }// index_of_2_when_listStr_is_empty_should_return_negative_1()

    @Test
    public void index_of_2_when_list_is_empty_should_return_negative_1(){
        Assertions.assertThat(this.list.indexOf(2)).isEqualTo(-1);
    }// index_of_2_when_list_is_empty_should_return_negative_1()

    @Test
    public void index_of_abc_when_listStr_is_empty_should_return_negative_1(){
        Assertions.assertThat(this.listStr.indexOf("abc")).isEqualTo(-1);
    }// index_of_1_when_listStr_is_empty_should_return_negative_1()

    @Test
    public void index_of_2_when_list_already_initialized_should_return_idx_1(){
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        Assertions.assertThat(this.list.indexOf(2)).isEqualTo(1);
    }// index_of_2_when_list_already_initialized_should_return_idx_1()

    @Test
    public void index_of_def_when_list_already_initialized_should_return_idx_1(){
        this.listStr.add("abc");
        this.listStr.add("def");
        Assertions.assertThat(this.listStr.indexOf("def")).isEqualTo(1);
    }// index_of_def_when_list_already_initialized_should_return_idx_1()

    @Test
    public void contains_99_when_list_already_initialized_should_return_false(){
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        Assertions.assertThat(this.list.contains(99)).isEqualTo(false);
    }// contains_99_when_list_already_initialized_should_return_false()

    @Test
    public void contains_2_when_list_is_empty_should_return_false(){
        Assertions.assertThat(this.list.contains(2)).isEqualTo(false);
    }// contains_2_when_list_is_empty_should_return_false()

    @Test
    public void contains_def_when_list_already_initialized_should_return_false(){
        this.listStr.add("abc");
        this.listStr.add("ghi");
        Assertions.assertThat(this.listStr.contains("def")).isEqualTo(false);
    }// contains_def_when_list_already_initialized_should_return_false()

    @Test
    public void contains_2_when_list_already_initialized_should_return_true(){
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        Assertions.assertThat(this.list.contains(2)).isEqualTo(true);
    }// contains_2_when_list_already_initialized_should_return_true()

    @Test
    public void contains_def_when_list_already_initialized_should_return_true(){
        this.listStr.add("abc");
        this.listStr.add("def");
        Assertions.assertThat(this.listStr.contains("def")).isEqualTo(true);
    }// contains_def_when_list_already_initialized_should_return_true()

    @Test
    public void to_string_when_list_is_initialized_should_display_values(){
        for(int i = 1; i < 4; ++i){
            this.list.add(i);
        }
        Assertions.assertThat(this.list.toString()).isEqualTo("[1, 2, 3]");
    }// to_string_when_list_is_initialized_should_display_values()

    @Test
    public void to_string_when_list_is_empty_should_display_empty_list(){
        Assertions.assertThat(this.list.toString()).isEqualTo("[]");
    }// to_string_when_list_is_initialized_should_display_values()

}// SimpleListUT

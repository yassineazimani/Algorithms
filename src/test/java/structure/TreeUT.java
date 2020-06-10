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

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

@RunWith(JUnit4.class)
public class TreeUT {

    private BinaryTreeSearch<Integer> tree;

    @Before
    public void setUp(){
        this.tree = new BinaryTreeSearch<>();
    }// setUp()

    @Test
    public void tree_should_be_empty(){
        Assertions.assertThat(this.tree.isEmpty()).isTrue();
    }// tree_should_be_empty()

    @Test
    public void tree_should_not_be_empty_when_node_added(){
        this.tree.addNode(9);
        Assertions.assertThat(this.tree.isEmpty()).isFalse();
    }// tree_should_not_be_empty_when_node_added()

    @Test
    public void search_min_should_be_return_2_when_nodes_are_9_2_15(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        Assertions.assertThat(this.tree.searchMin()).isEqualTo(2);
    }// search_min_should_be_return_2_when_nodes_are_9_2_15()

    @Test
    public void search_min_should_be_return_n5_when_nodes_are_9_2_15_n5(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(-5);
        Assertions.assertThat(this.tree.searchMin()).isEqualTo(-5);
    }// search_min_should_be_return_n5_when_nodes_are_9_2_15_n5()

    @Test
    public void search_max_should_be_return_15_when_nodes_are_9_2_15(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        Assertions.assertThat(this.tree.searchMax()).isEqualTo(15);
    }// search_max_should_be_return_15_when_nodes_are_9_2_15()

    @Test
    public void search_max_should_be_return_195_when_nodes_are_9_2_195_n5(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(195);
        Assertions.assertThat(this.tree.searchMax()).isEqualTo(195);
    }// search_max_should_be_return_195_when_nodes_are_9_2_195_n5()

    @Test
    public void search_15_should_be_return_node_with_value_15(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(195);
        Optional<BinaryTreeSearch<Integer>> optValue = this.tree.search(15);
        Assertions.assertThat(optValue).isPresent();
        Assertions.assertThat(optValue.get().getValue()).isEqualTo(15);
    }// search_15_should_be_return_node_with_value_15()

    @Test
    public void search_2_should_be_return_node_with_value_2(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(195);
        Optional<BinaryTreeSearch<Integer>> optValue = this.tree.search(2);
        Assertions.assertThat(optValue).isPresent();
        Assertions.assertThat(optValue.get().getValue()).isEqualTo(2);
    }// search_2_should_be_return_node_with_value_2()

    @Test
    public void search_50_should_be_return_empty_optional(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(195);
        Optional<BinaryTreeSearch<Integer>> optValue = this.tree.search(50);
        Assertions.assertThat(optValue).isNotPresent();
    }// search_50_should_be_return_empty_optional()

    @Test
    public void get_height_should_be_return_1(){
        this.tree.addNode(9);
        Assertions.assertThat(this.tree.getHeight()).isEqualTo(1);
    }// get_height_should_be_return_1()

    @Test
    public void get_height_should_be_return_3(){
        this.tree.addNode(9);
        this.tree.addNode(2);
        this.tree.addNode(15);
        this.tree.addNode(195);
        Assertions.assertThat(this.tree.getHeight()).isEqualTo(3);
    }// get_height_should_be_return_3()

    @Test
    public void parcours_prefixe_should_be_5_1_2_3_4_6_7_8_9_10_when_nodes_are_5_1_2_3_4_6_7_8_9_10(){
        this.tree.addNode(5);
        this.tree.addNode(1);
        this.tree.addNode(2);
        this.tree.addNode(3);
        this.tree.addNode(4);
        this.tree.addNode(6);
        this.tree.addNode(7);
        this.tree.addNode(8);
        this.tree.addNode(9);
        this.tree.addNode(10);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        this.tree.printParcoursPreFixe();
        Assertions.assertThat("5 1 2 3 4 6 7 8 9 10 ").isEqualTo(outContent.toString());
    }// parcours_prefixe_should_be_1_2_4_8_9_5_10_3_6_7_when_nodes_are_1_2_3_4_5_6_7_8_9_10()

    @Test
    public void parcours_infixe_should_be_1_2_3_4_5_6_7_8_9_10_when_nodes_are_1_2_3_4_5_6_7_8_9_10(){
        this.tree.addNode(5);
        this.tree.addNode(1);
        this.tree.addNode(2);
        this.tree.addNode(3);
        this.tree.addNode(4);
        this.tree.addNode(6);
        this.tree.addNode(7);
        this.tree.addNode(8);
        this.tree.addNode(9);
        this.tree.addNode(10);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        this.tree.printParcoursInFixe();
        Assertions.assertThat("1 2 3 4 5 6 7 8 9 10 ").isEqualTo(outContent.toString());
    }// parcours_infixe_should_be_1_2_3_4_5_6_7_8_9_10_when_nodes_are_1_2_3_4_5_6_7_8_9_10()

    @Test
    public void parcours_postfixe_should_be_8_9_4_10_5_2_6_7_3_1_when_nodes_are_1_2_3_4_5_6_7_8_9_10(){
        this.tree.addNode(5);
        this.tree.addNode(1);
        this.tree.addNode(2);
        this.tree.addNode(3);
        this.tree.addNode(4);
        this.tree.addNode(6);
        this.tree.addNode(7);
        this.tree.addNode(8);
        this.tree.addNode(9);
        this.tree.addNode(10);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        this.tree.printParcoursPostFixe();
        Assertions.assertThat("4 3 2 1 10 9 8 7 6 5 ").isEqualTo(outContent.toString());
    }// parcours_postfixe_should_be_8_9_4_10_5_2_6_7_3_1_when_nodes_are_1_2_3_4_5_6_7_8_9_10()

}// TreeUT

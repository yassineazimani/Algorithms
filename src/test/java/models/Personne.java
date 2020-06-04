package models;

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
public class Personne implements Comparable{

    private int age;

    public Personne(int age) {
        this.age = age;
    }// models.Personne()


    @Override
    public int compareTo(Object o) {
        return this.age - ((Personne) o).age;
    }// compareTo()

    @Override
    public String toString() {
        return "{" + age + "}";
    }// toString()

}// models.Personne

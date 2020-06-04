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

import org.apache.commons.lang3.StringUtils;

public class Palindromes {

    public static boolean isPalindrome(String word) {
        int lengthWord = word != null ? word.length() : 0;
        if(lengthWord <= 1){
            return false;
        }
        int idxAtMiddle = (int) Math.floor(lengthWord);
        String wordWithoutAccents = StringUtils.stripAccents(word);
        for(int i = 0, j = lengthWord-1; i < idxAtMiddle; ++i, --j){
            if(wordWithoutAccents.charAt(i) != wordWithoutAccents.charAt(j)){
                return false;
            }
        }
        return true;
    }// isPalindrome()

}// Palindromes

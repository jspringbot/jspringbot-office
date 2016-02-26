/*
 * Copyright (c) 2015. JSpringBot. All Rights Reserved.
 *
 * See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The JSpringBot licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jspringbot.keyword.office;

import org.jspringbot.KeywordInfo;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@KeywordInfo(
        name = "Word Insert Image",
        parameters = {"path", "*dimension"},
        description = "classpath:desc/WordInsertImage.txt"
)
public class WordInsertImage extends AbstractWordKeyword {

    @Override
    public Object execute(Object[] params) throws Exception {
        if(params.length == 1) {
            if(File.class.isInstance(params[0])) {
                helper.insertImage((File) params[0]);
            } else {
                helper.insertImage(String.valueOf(params[0]));
            }
        } else if(params.length >= 3) {
            if(File.class.isInstance(params[0])) {
                helper.insertImage((File) params[0], Integer.parseInt(String.valueOf(params[1])), Integer.parseInt(String.valueOf(params[2])));
            } else {
                helper.insertImage(String.valueOf(params[0]), Integer.parseInt(String.valueOf(params[1])), Integer.parseInt(String.valueOf(params[2])));
            }
        } else {
            throw new IllegalArgumentException("Illegal number of parameters.");
        }

        return null;
    }
}

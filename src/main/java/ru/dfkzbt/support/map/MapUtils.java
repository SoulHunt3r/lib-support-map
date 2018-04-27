/*
 *    Copyright 2018 Konstantin Fedorov
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.dfkzbt.support.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MAP Support class
 *
 * @author Fedorov Konstantin (mr.fedorov.konstantin@mail.ru)
 * @version 0.1
 * Created on 27.04.2018.
 */
public class MapUtils {
    private final static Logger logger = LoggerFactory.getLogger(MapUtils.class);

    private MapUtils() {
    }

    /**
     * Form a list of keys that contain given value and return it
     *
     * @param map   for search in
     * @param value value to search for
     * @return list of keys that contain given value
     */
    public static <T, E> List<T> getKeysByValue(Map<T, E> map, E value) {
        List<T> list = new ArrayList<>();

        for (T key : map.keySet()) {
            E obj = map.get(key);

            if (obj == null && value != null) continue;
            if (obj != null && !obj.equals(value)) continue;

            list.add(key);
        }

        return list;
    }

    /**
     * Just print map
     *
     * @param map to print
     */
    public static <T, E> void printMap(Map<T, E> map) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            logger.debug("Entry: key= {}, value= {}", entry.getKey(), entry.getValue());
        }
    }
}

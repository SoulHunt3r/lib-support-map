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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Generic description
 *
 * @author Fedorov Konstantin (mr.fedorov.konstantin@mail.ru)
 * @version 0.2.0-SNAPSHOT
 * Created on 27.04.2018.
 */
public class MapUtilsTest {
    private final static Logger logger = LoggerFactory.getLogger(MapUtilsTest.class);

    @Test
    public void getKeysByValue() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 42);
        map.put(2, 42);
        map.put(4, 4);
        map.put(8, 42);

        MapUtils.printMap(map);

        List<Integer> list1 = MapUtils.getKeysByValue(map, 42);
        List<Integer> list2 = MapUtils.getKeysByValue(map, 4);
        logger.debug("list1: {}", list1);
        logger.debug("list2: {}", list2);

        Integer[] expected1 = new Integer[]{1, 2, 8};
        Integer[] expected2 = new Integer[]{4};

        assertArrayEquals(expected1, list1.toArray(new Integer[0]));
        assertArrayEquals(expected2, list2.toArray(new Integer[0]));
    }
}
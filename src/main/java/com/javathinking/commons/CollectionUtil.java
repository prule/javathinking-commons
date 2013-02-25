package com.javathinking.commons;

import java.util.List;

/**
 * @author paul
 */
public class CollectionUtil {
    public static Object first(List list) {
        if (list != null && list.size() > 0) return list.get(0);
        return null;
    }
}

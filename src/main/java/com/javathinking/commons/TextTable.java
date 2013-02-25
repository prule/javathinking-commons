package com.javathinking.commons;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author prule
 */
public class TextTable {

    public enum ALIGN {
        LEFT, RIGHT, CENTER
    }

    ;
    private List<Object[]> data = new ArrayList();
    private Map<Integer, Integer> maxWidths = new HashMap();
    private ALIGN[] alignment;
    private String leftPad = "";

    public TextTable(String leftPad, ALIGN... alignment) {
        this.alignment = alignment;
        this.leftPad = leftPad;
    }

    public void clear() {
        data = new ArrayList<Object[]>();
    }

    public TextTable add(Object... objs) {
        data.add(objs);
        int col = 0;
        for (Object object : objs) {
            String val = object.toString();
            if (!maxWidths.containsKey(col) || val.length() > maxWidths.get(col)) {
                maxWidths.put(col, val.length());
            }
            col++;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object[] objects : data) {
            sb.append(leftPad);
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];
                if (alignment.length > i) {
                    switch (alignment[i]) {
                        case CENTER:
                            sb.append(StringUtils.center(object.toString(), maxWidths.get(i)));
                            break;
                        case RIGHT:
                            sb.append(StringUtils.leftPad(object.toString(), maxWidths.get(i)));
                            break;
                        default:
                            sb.append(StringUtils.rightPad(object.toString(), maxWidths.get(i)));
                            break;
                    }
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

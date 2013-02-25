package com.javathinking.commons.persistence;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paul
 */
public class SimpleJpqQuery {

    private int groupCount = 0;

    public enum Op {

        and, or
    }

    ;
    private Map<String, Object> params = new HashMap<String, Object>();
    private StringBuilder sb = new StringBuilder();

    public SimpleJpqQuery(Class clz) {
        sb.append("from ");
        sb.append(clz.getSimpleName());
        sb.append(" o where 1=1 ");
    }

    public SimpleJpqQuery add(Op op, Comparison comp, PropertyName property, Object value) {
        return add(op, comp, property, value, false, null);
    }

    public SimpleJpqQuery add(Op op, Comparison comp, PropertyName property, Object value, String function) {
        return add(op, comp, property, value, false, function);
    }

    private SimpleJpqQuery add(Op op, Comparison comp, PropertyName property, Object value, boolean useBracket, String function) {

        if (value != null || comp == Comparison.isnull) {
            sb.append(" ");
            sb.append(op.name());
            if (useBracket) {
                sb.append(" (");
            }
            if (function != null) sb.append(" ").append(function).append('(');
            sb.append(" o.").append(property);
            if (function != null) sb.append(')');
            sb.append(" ");
            sb.append(comp);
            if (value != null) {
                if (function != null) sb.append(" ").append(function).append('(');
                sb.append(" :");
                sb.append(property.getName() + params.size());
                if (function != null) sb.append(')');
                params.put(property.getName() + params.size(), comp.property(value));
            }
        }
        return this;
    }

    public SimpleJpqQuery group(Op op, Comparison comp, PropertyName property, Object value) {
        add(op, comp, property, value, true, null);
        groupCount++;
        return this;
    }

    public SimpleJpqQuery ungroup() {
        sb.append(')');
        groupCount--;
        return this;
    }

    public SimpleJpqQuery order(PropertyName property) {
        sb.append(" order by " + property.getName());
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String getSelectAll() {
        return closeGroups(sb.toString());

    }

    public String getSelect(String select) {
        return closeGroups("select " + select + " " + sb.toString());
    }

    public String getSelectCount() {
        return closeGroups("select count(o) " + sb.toString());
    }

    private String closeGroups(String sql) {
        if (groupCount > 0) {
            return StringUtils.rightPad(sql, groupCount, ")");
        } else {
            return sql;
        }
    }
}

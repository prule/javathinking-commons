package com.javathinking.commons.persistence;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.util.Date;

/**
 * @author paul
 */
public class GenericJpaDao extends JpaDaoSupport {

    public static SimpleJpqQuery query(Class clz, Date start, Date end, PropertyName property) {
        return new SimpleJpqQuery(clz)
                .add(SimpleJpqQuery.Op.and, Comparison.ge, property, start)
                .add(SimpleJpqQuery.Op.and, Comparison.lt, property, end);
    }
}

package com.javathinking.commons.persistence;

/**
 * @author paul
 */
public enum Comparison {
    eq("="), like("like", "%"), gt(">"), ge(">="), lt("<"), le("<="), isnull("is null");

    private String keyword;
    private String wrapper;

    Comparison(String keyword) {
        this(keyword, null);
    }

    Comparison(String keyword, String wrapper) {
        this.keyword = keyword;
        this.wrapper = wrapper;
    }

    @Override
    public String toString() {
        return keyword;
    }

    public Object property(Object obj) {
        if (wrapper == null) {
            return obj;
        }
        return wrapper + (String) obj + wrapper;
    }


}

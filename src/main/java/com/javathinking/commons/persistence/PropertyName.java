package com.javathinking.commons.persistence;

/**
 * @author paul
 */
public class PropertyName {
    private String name;

    public PropertyName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public static PropertyName n(String name) {
        return new PropertyName(name);
    }

    public PropertyName concat(PropertyName p2) {
        return new PropertyName(this.getName() + "." + p2.getName());
    }
}

package com.javathinking.commons.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author paul
 */
@Entity
public class Configuration {
    @Column
    private String name;
    @Column
    private String value;
    @Column
    private Long index;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}

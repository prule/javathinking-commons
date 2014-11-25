package com.javathinking.commons.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paul
 */
public class ConfigurationServiceImpl {
    @Autowired
    private ConfigurationRepository dao;

    public Integer getInt(String name) {
        final List<Configuration> value = dao.findAllByNameOrderByIndex(name);
        return Integer.parseInt(value.get(0).getValue());
    }

    public List<Integer> getInts(String name) {
        List<String> strings = strings(name);
        List<Integer> results = new ArrayList();
        for (String string : strings) {
            results.add(Integer.parseInt(string));
        }
        return results;
    }


    public String getString(String name) {
        return strings(name).get(0);
    }

    public List<String> getStrings(String name) {
        return strings(name);
    }

    private List<String> strings(String name) {
        List<String> result = new ArrayList();
        final List<Configuration> values = dao.findAllByNameOrderByIndex(name);
        for (Configuration value : values) {
            result.add(value.getValue());
        }
        return result;
    }

}

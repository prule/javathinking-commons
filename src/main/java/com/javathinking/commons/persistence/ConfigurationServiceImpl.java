package com.javathinking.commons.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paul
 */
public class ConfigurationServiceImpl {
    private ConfigurationDao dao;

    public Integer getInt(String name) {
        final List<Configuration> value = dao.get(name);
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
        final List<Configuration> values = dao.get(name);
        for (Configuration value : values) {
            result.add(value.getValue());
        }
        return result;
    }

    public void setDao(ConfigurationDao dao) {
        this.dao = dao;
    }

}

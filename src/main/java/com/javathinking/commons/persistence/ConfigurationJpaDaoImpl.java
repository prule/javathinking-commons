package com.javathinking.commons.persistence;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.util.List;

/**
 * @author paul
 */
public class ConfigurationJpaDaoImpl extends JpaDaoSupport implements ConfigurationDao {
    public List<Configuration> get(String name) {
        return getJpaTemplate().find("from Configuration where name=? order by index", name);
    }
}

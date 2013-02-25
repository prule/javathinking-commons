package com.javathinking.commons.persistence;

import java.util.List;

/**
 * @author paul
 */
public interface ConfigurationDao {

    List<Configuration> get(String name);

}

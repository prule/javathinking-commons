package com.javathinking.commons.persistence;

import java.util.List;

public interface ConfigurationRepository {
    List<Configuration> findAllByNameOrderByIndex(String name);
}

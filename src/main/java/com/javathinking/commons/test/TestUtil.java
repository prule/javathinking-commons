package com.javathinking.commons.test;

import java.io.File;
import java.net.URL;

/**
 * @author paul
 */
public class TestUtil {
    public static File getFile(Object obj, String filename) {
        URL url = obj.getClass().getClassLoader().getResource(filename);
        return new File(url.getFile());
    }

    public static File getTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"), "com.javathinking");
        file.mkdirs();
        return file;
    }

}

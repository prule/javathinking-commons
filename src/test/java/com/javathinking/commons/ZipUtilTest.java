package com.javathinking.commons;

import com.javathinking.commons.test.TestUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author paul
 */
public class ZipUtilTest {

    @Test
    public void testUnzip() throws Exception {
        File file = TestUtil.getFile(this, "zip1.zip");
        File dest = TestUtil.getTempDir();
        FileUtils.cleanDirectory(dest);
        ZipUtil.unzip(file, dest);

        assertTrue(getFile(dest, "1a.txt").exists());
        assertTrue(getFile(dest, "2a.txt").exists());

        assertTrue(getFile(dest, "b").exists());
        assertTrue(getFile(dest, "b").isDirectory());
        assertTrue(getFile(dest, "b", "1b.txt").exists());

        assertTrue(getFile(dest, "c").exists());
        assertTrue(getFile(dest, "c").isDirectory());
        assertTrue(getFile(dest, "c", "1c.txt").exists());
        assertEquals(4, getFile(dest, "c", "1c.txt").length());
        assertTrue(getFile(dest, "c", "2c.txt").exists());
        assertTrue(getFile(dest, "c", "a.png").exists());
        assertEquals(447, getFile(dest, "c", "a.png").length());

        assertTrue(getFile(dest, "c", "d").exists());
        assertTrue(getFile(dest, "c", "d").isDirectory());

        FileUtils.cleanDirectory(dest);

    }

    private File getFile(File dir, String... paths) {
        File f = dir;
        for (String path : paths) {
            f = new File(f, path);
        }
        return f;
    }


}

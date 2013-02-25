package com.javathinking.commons;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author paul
 */
public class ZipUtil {

    public static int unzip(File zip, File dest) {
        try {
            ZipFile zf = new ZipFile(zip);
            int count = 0;
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                File destfile = new File(dest, entry.getName());
                if (entry.isDirectory()) {
                    destfile.mkdirs();
                } else {
                    IOUtils.copy(zf.getInputStream(entry), new FileOutputStream(destfile));
                }
            }
            return count;
        } catch (IOException e) {
            return -1;
        }
    }

    public static int countFiles(File zip) {
        try {
            ZipFile zf = new ZipFile(zip);
            int count = 0;
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                count++;
                entries.nextElement();
            }
            return count;
        } catch (IOException e) {
            return -1;
        }
    }

    public static boolean isValid(File zip) {
        return countFiles(zip) >= 0;
    }


}

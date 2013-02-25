package com.javathinking.commons.test;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author paul
 */
public class XmlDiffIgnoreTest {

    private List<String> xpaths;
    private XmlDiffIgnore xdi;
    private static final String xpath1 = "a/b/c";
    private static final String xpath2 = "a/e";
    private static final String xpath3 = "a/f/g";

    @Before
    public void setup() {
        xdi = new XmlDiffIgnore();
        xdi.addXpath(xpath1);
        xdi.addXpath(xpath2);

        xdi.addValue("11111");
        xdi.addValue("22222");
    }

    @Test
    public void ignoreXpath() {
        Assert.assertTrue(xdi.ignoreXpath(xpath1));
        Assert.assertTrue(xdi.ignoreXpath(xpath2));
        Assert.assertFalse(xdi.ignoreXpath(xpath3));
    }
/*
    @Test
    public void compareFiles() throws Exception {
        // check the file is actually different
        XMLAssert.assertXMLNotEqual(new InputSource(
                this.getClass().getClassLoader().getResourceAsStream("com/javathinking/commons/test/file1.xml")),
                new InputSource(this.getClass().getClassLoader().getResourceAsStream("com/javathinking/commons/test/file1a.xml")));

        //new FileReader(new File("./src/test/java/com/javathinking/commons/test/file1.xml")),
        //new FileReader(new File("./src/test/java/com/javathinking/commons/test/file1a.xml")));

        // now check it is considered the same by ignoring specified xpaths
        Diff diff = new Diff(
                new FileReader(new File("./src/test/java/com/javathinking/commons/test/file1.xml")),
                new FileReader(new File("./src/test/java/com/javathinking/commons/test/file1a.xml")));

        DetailedDiff dDiff = new DetailedDiff(diff);
        dDiff.overrideDifferenceListener(xdi);
        Assert.assertTrue(dDiff.similar());
        Assert.assertFalse(dDiff.identical());
    }
*/
}

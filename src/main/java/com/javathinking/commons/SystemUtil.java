package com.javathinking.commons;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author prule
 */
public class SystemUtil {

    public static String hostname() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            return addr.getHostName();
        } catch (UnknownHostException e) {
            return "unknown";
        }
    }
}

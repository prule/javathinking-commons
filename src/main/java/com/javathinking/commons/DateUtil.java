package com.javathinking.commons;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author paul
 */
public abstract class DateUtil {
    private static final String[] patterns = {"dd/MM/yyyy"};

    public static Date date(String date) {
        try {
            return DateUtils.parseDate(date, patterns);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Date date(int year, int month, int day) {
        return date(day + "/" + month + "/" + year);
    }

    public static int currentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int diff(Date date, Date previous) {
        return (int) ((date.getTime() - previous.getTime()) / (1000 * 60 * 60 * 24));
    }
}

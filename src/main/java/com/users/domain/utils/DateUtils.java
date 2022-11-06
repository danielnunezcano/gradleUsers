package com.users.domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final Integer RANGE_AGE = 18;

    public static LocalDate stringToDate(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateToLocalDate(date);
    }

    public static Boolean ageLess18(final LocalDate date) {
        Calendar calendarRange18 = localDateToCalendar(date);
        calendarRange18.add(Calendar.YEAR, RANGE_AGE);
        if (calendarToDate(calendarRange18).compareTo(new Date()) > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private static Calendar localDateToCalendar(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
        return calendar;
    }

    private static LocalDate dateToLocalDate(final Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }


}

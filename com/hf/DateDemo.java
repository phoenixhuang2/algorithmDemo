package com.hf;

import java.rmi.registry.LocateRegistry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author huangfeng
 * @Date: Created in 12:54 下午 2020/12/2
 * @Description
 **/
public class DateDemo {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println(System.currentTimeMillis());
//        Date date2 = new Date(date.getTime());
//        System.out.println(date2.toString());
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date2));
//
//        try {
//            Date date3 = simpleDateFormat.parse("2020-11-23 星期二 12:23:12");
//            System.out.println(date3.toString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar.getInstance();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());


        LocalDate localDate = LocalDate.of(1989, 9, 28);
        LocalTime localTime = LocalTime.of(10, 8);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime1.toString());

        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localTime.getHour());

        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(21);
        System.out.println(localDateTime2.toString());
        System.out.println(localDateTime1.toString());

        LocalDateTime localDateTime3 = localDateTime1.plusDays(10);
        System.out.println(localDateTime3);

        System.out.println(Instant.now().toEpochMilli());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime3.format(dateTimeFormatter));

        LocalDate localDate4 = LocalDate.parse("2020-10-23 12:22:10", dateTimeFormatter);
        System.out.println(localDate4.getMonthValue());

        LocalDateTime localDateTime4 = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime4.toString());

        System.out.println(ZonedDateTime.now());

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(12,11, 20);
        System.out.println(Duration.between(localTime1, localTime2).toDays());

        LocalDateTime localDateTime5 = LocalDateTime.of(LocalDate.of(2020, 12, 2), LocalTime.of(11, 22));
        LocalDateTime localDateTime6 = LocalDateTime.of(LocalDate.of(2019, 12, 2), LocalTime.of(11, 22));
        System.out.println(Duration.between(localDateTime5, localDateTime6).toDays());
    }
}

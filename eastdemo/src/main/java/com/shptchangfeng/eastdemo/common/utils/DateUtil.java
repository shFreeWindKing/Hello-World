package com.shptchangfeng.eastdemo.common.utils;

import org.apache.commons.lang3.StringUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author 冯梁
 * @date 2020/06/08
 */
public class DateUtil {

    //  本util涉及zoneId 都采用系统默认的时区
    private static final ZoneId ZONE_ID_SYSTEM_DEFAULT = ZoneId.systemDefault();

    /**
     * 常用日期格式
     **/
    public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

    public final static String DATE_FORMAT = "yyyy-MM-dd";

    public final static String SHORT_DATE_FORMAT = "MM-dd";

    public final static String SHORT_TIME_FORMAT = "HH:mm";

    public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 数据库默认时间
     */
    public final static String DEFAULT_TIME="1000-01-01 00:00:00";

    /**
     * 将指定的时间日期类转为指定格式的String
     * LocalDateTime  yyyy MM dd HH mm ss
     * LocalDate     yyyy MM dd
     * LocalTime     HH mm ss
     *
     * @param temporalAccessor 共同接口
     * @param pattern          自定义转化格式
     * @return
     */
    public static String format(TemporalAccessor temporalAccessor, String pattern) {
        if (temporalAccessor == null) {
            return "";
        }
        DateTimeFormatter formatter = getFormatter(pattern);
        if (formatter != null) {
            return formatter.format(temporalAccessor);
        }
        return "";
    }

    /**
     * 获取日期时间转换器
     *
     * @param pattern 自定义转化格式
     * @return
     */
    public static DateTimeFormatter getFormatter(String pattern) {
        if (isEmpty(pattern)) {
            return null;
        }
        return DateTimeFormatter.ofPattern(pattern);
    }

    /**
     * 由毫秒值获取默认zoneId的日期时间
     *
     * @param timMillion 时间毫秒值
     * @return
     */
    public static LocalDateTime getDateTime(long timMillion) {
        Instant instant = Instant.ofEpochMilli(timMillion);
        return LocalDateTime.ofInstant(instant, ZONE_ID_SYSTEM_DEFAULT);
    }

    /**
     * 由指定日期时间获默认zoneId取毫秒值
     *
     * @param localDateTime 日期时间
     * @return
     */
    public static long getTimeMillion(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZONE_ID_SYSTEM_DEFAULT).toInstant();
        return instant.toEpochMilli();
    }


    /**
     * 将String按照自定格式转化为 LocalDateTime
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDateTime parseDateTime(String dateStr, String pattern) {
        if (isEmpty(dateStr)) {
            return null;
        }
        DateTimeFormatter formatter = getFormatter(pattern);
        if (formatter == null) {
            return null;
        }
        return LocalDateTime.parse(dateStr, formatter);
    }

    /**
     * 将String按照自定格式转化为 LocalDate
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDate parseDate(String dateStr, String pattern) {
        if (isEmpty(dateStr)) {
            return null;
        }
        DateTimeFormatter formatter = getFormatter(pattern);
        if (formatter == null) {
            return null;
        }
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * 将String按照自定格式转化为 LocalTime
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalTime parseTime(String dateStr, String pattern) {
        if (isEmpty(dateStr)) {
            return null;
        }
        DateTimeFormatter formatter = getFormatter(pattern);
        if (formatter == null) {
            return null;
        }
        return LocalTime.parse(dateStr, formatter);
    }

    /**
     * 计算两个时间类的差值（天 小时 分钟 秒 毫秒）LocalDateTime LocalDate LocalTime
     *
     * @param begin 共同接口
     * @param end   共同接口
     * @param type  差值类型（天 小时 分钟 秒 毫秒）
     * @return
     */
    public static Long diffDate(Temporal begin, Temporal end, Type type) {
        Duration duration = Duration.between(begin, end);
        if (type == Type.DAY) {//天
            return duration.toDays();
        } else if (type == Type.HOUR) {//小时
            return duration.toHours();
        } else if (type == Type.MINUTE) {//分钟
            return duration.toMinutes();
        } else if (type == Type.SECOND) {//秒
            return duration.toMillis() / 1000;
        } else {
            return duration.toMillis(); //return 毫秒值
        }
    }

    private static boolean isEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    /**
     * 时间差类型
     */
    public enum Type {
        DAY, HOUR, MINUTE, SECOND, MILLIS
    }

    /**
     * 获取默认时间
     * @return
     */
    public static Date getDefaultDate(){
        return strToDate(DEFAULT_TIME, TIMEFORMAT);
    }

    public static Date strToDate(String dateStr, String formatType) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            } else {
                if (StringUtils.isBlank(formatType)) {
                    formatType = "yyyy-MM-dd";
                }

                DateFormat sdf = new SimpleDateFormat(formatType);
                return sdf.parse(dateStr);
            }
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
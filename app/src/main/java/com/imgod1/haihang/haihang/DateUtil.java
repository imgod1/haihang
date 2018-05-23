package com.imgod1.haihang.haihang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {

    public final static String FORMAT_DATE = "yyyy-MM-dd";
    public final static String FORMAT_DATE_POINT = "yyyy.MM.dd";
    public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_TIME = "HH:mm:ss";
    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE_ZH = "yyyy年MM月dd日";
    public final static String FORMAT_DATETIME_ZH = "yyyy年MM月dd日 HH时mm分ss秒";

    public final static String TYPE_DATE = "date";
    public final static String TYPE_DATETIME = "datetime";
    public final static String TYPE_DATE_TIME = "date_time";
    public final static String TYPE_TIME = "time";
    public static final SimpleDateFormat sformat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 开始和结束的时间类型
     */
    public static final int TYPE_BEGIN = 0;
    public static final int TYPE_END = 1;

    /**
     * 日期排序类型-升序
     */
    public final static int DATE_ORDER_ASC = 0;

    /**
     * 日期排序类型-降序
     */
    public final static int DATE_ORDER_DESC = 1;

    private static final String baseFormate = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间转化成Date
     */
    public static Date getDate(String time) {
        return getDate(time, baseFormate);
    }

    /**
     * 时间转化成Date
     *
     * @param time
     * @param formate
     * @return
     */
    public static Date getDate(String time, String formate) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(formate);
            date = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @return
     */
    public static String getCurrentDateStr() {
        return getCurrentDateStr(baseFormate);
    }

    /**
     * @param formate
     * @return
     */
    public static String getCurrentDateStr(String formate) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat(formate);
        String dateStr = df.format(date);
        return dateStr;
    }

    /**
     * 获取当前时间
     */
    public static Date getCurrentTime() {
        return getCurrentTime(baseFormate);
    }

    /**
     * 获取当前时间
     */
    public static Date getCurrentTime(String formate) {
        SimpleDateFormat formatter = new SimpleDateFormat(formate);
        Date curDate = new Date(System.currentTimeMillis());
        String date = formatter.format(curDate);
        return getDate(date);
    }

    public static boolean before(String date1, String date2, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date d1 = new Date();
        Date d2 = d1;

        try {
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d1.before(d2);
    }

    /**
     * 检查两个时间是否是前后关系
     *
     * @param date1 前一个日期
     * @param date2 后一个日期
     * @param f     日期格式
     * @return true为date1在date2后面 FORMAT_DATETIME
     */
    public static boolean after(String date1, String date2, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date d1 = new Date();
        Date d2 = d1;

        try {
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d1.after(d2);
    }

    public static String getFutherDate(int day, String dateStr, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr.substring(0, 10)).getTime()
                    + (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

    public static String getFutherDate(int day, String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr.substring(0, 10)).getTime()
                    + (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return d;
    }

    public static String getBeforeDate(int day, String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        long beforeDateTime;
        String d = "";
        try {
            beforeDateTime = df.parse(dateStr).getTime()
                    - (long) 3600 * 24 * 1000 * day;
            Date date = new Date(beforeDateTime);
            d = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return d;
    }

    public static String reFormat(String date, String f1, String f2) {
        SimpleDateFormat df1 = new SimpleDateFormat(f1);
        SimpleDateFormat df2 = new SimpleDateFormat(f2);
        Date d1 = new Date();
        try {
            d1 = df1.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return df2.format(d1);
    }

    public static Map<String, Object> getMyDate(int count) {
        Map<String, Object> map = new HashMap<String, Object>();
        Date currentDate = Calendar.getInstance().getTime();
        Calendar cl = Calendar.getInstance();
        cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH) + count);
        System.out.println(formatZh(currentDate, TYPE_DATE));
        System.out.println(formatZh(cl.getTime(), TYPE_DATE));
        Date endDate = cl.getTime();
        List<Date> mDateList = getBetweenDates(currentDate, endDate);
        map.put("date", mDateList);
        String[] name = new String[mDateList.size()];
        if (mDateList != null) {
            for (int i = 0; i < mDateList.size(); i++) {
                Date d = mDateList.get(i);
                if (i == 0) {
                    name[i] = "今天";
                } else if (i == 1) {
                    name[i] = "明天";
                } else if (i == 2) {
                    name[i] = "后天";
                } else {
                    name[i] = getDateAndWeek(d);
                }
            }
        }
        map.put("name", name);
        return map;
    }

    /**
     * 转换日期对象为中文化日期
     *
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型, date和datetime
     */
    public static String formatZh(Date dateValue, String dateType) {
        if (dateValue == null)
            return "";
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof Date) {
            switch (dateType) {
                case TYPE_DATE:
                    SimpleDateFormat sfdate = new SimpleDateFormat(
                            FORMAT_DATE_ZH);
                    return sfdate.format(dateValue);
                case TYPE_DATETIME:
                    SimpleDateFormat sftime = new SimpleDateFormat(
                            FORMAT_DATETIME_ZH);
                    return sftime.format(dateValue);
                default:
                    return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param t1 时间1
     * @param t2 时间2
     * @return t2 与t1的间隔天数
     * @throws ParseException 如果输入的日期格式不一致0000-00-00 格式抛出异常
     * @author color
     */
    public static long getBetweenDays(String t1, String t2) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long betweenDays = 0;
        Date d1 = format.parse(t1);
        Date d2 = format.parse(t2);
        betweenDays = getBetweenDays(d1, d2);
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔天数
     */
    public static long getBetweenDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        long betweenHours = getBetweenHours(d1, d2);
        long betweenDays = betweenHours / ONE_DAY_HOUR;
        return betweenDays;
    }

    /**
     * 取得两个日期段的日期间隔 不超过24小时算1天 超过24小时就算2天
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔天数
     */
    public static long getSmartBetweenDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        long betweenHours = getSmartBetweenHours(d1, d2);
        long betweenDays = 0;
        if (betweenHours % ONE_DAY_HOUR == 0) {
            betweenDays = betweenHours / ONE_DAY_HOUR;
        } else {
            betweenDays = betweenHours / ONE_DAY_HOUR + 1;
        }
        return betweenDays;
    }


    public static int ONE_HOUR_SECONDS = 3600;//一小时3600秒
    public static int ONE_MINUTE_SECONDS = 60;//一分钟60秒
    public static int ONE_DAY_HOUR = 24;//一天的小时数

    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔小时数
     */
    public static long getBetweenHours(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        long betweenSeconds = getBetweenSeconds(d1, d2);
        long betweenHours = betweenSeconds / ONE_HOUR_SECONDS;//间隔的小时数 只取整数
        return betweenHours;
    }


    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔小时数
     */
    public static long getSmartBetweenHours(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        long betweenSeconds = getBetweenSeconds(d1, d2);
        long betweenHours = 0;
        if (betweenSeconds % ONE_HOUR_SECONDS == 0) {
            betweenHours = betweenSeconds / ONE_HOUR_SECONDS;
        } else {
            betweenHours = betweenSeconds / ONE_HOUR_SECONDS + 1;
        }
        return betweenHours;
    }


    /**
     * 取得两个日期段的日期间隔
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return t2 与t1的间隔秒数
     */
    public static long getBetweenSeconds(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return -1;
        }
        long startSecond = d1.getTime() / 1000;//开始的秒数
        long endSecond = d2.getTime() / 1000;//结束的秒数
        long betweenSecond = endSecond - startSecond;
        return betweenSecond;
    }


    public static String getDateAndWeek(Date date) {
        return formatZh(date, TYPE_DATE).substring(5) + date2Week(date);
    }

    public static String date2Week(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        return DateUtil.WeekToweek(sdf.format(date));
    }

    /**
     * 星期几转换成周几
     *
     * @param str
     * @return
     */
    public static String WeekToweek(String str) {
        if (str.equals("星期天")) {
            return "周日";
        } else if (str.equals("星期一")) {
            return "周一";
        } else if (str.equals("星期二")) {
            return "周二";
        } else if (str.equals("星期三")) {
            return "周三";
        } else if (str.equals("星期四")) {
            return "周四";
        } else if (str.equals("星期五")) {
            return "周五";
        } else if (str.equals("星期六")) {
            return "周六";
        } else {
            return str;
        }
    }

    public static List<Date> getBetweenDates(Date fromDate, Date toDate) {
        List<Date> result = new ArrayList<Date>();
        // 如果�?始日期大于结束日期交�?
        if (toDate.getTime() < fromDate.getTime()) {
            Date tempDate = fromDate;
            fromDate = toDate;
            toDate = tempDate;
        }

        Calendar ca = Calendar.getInstance();
        while (fromDate.getTime() <= toDate.getTime()) {
            ca.setTime(fromDate);
            Date tempDate = new Date(ca.getTime().getTime());
            result.add(tempDate);
            ca.add(Calendar.DATE, 1);
            fromDate = new java.sql.Date(ca.getTime().getTime());
        }
        return result;
    }

    /**
     * @dateValue 日期对象，可以是java.util.Date和java.sql.Date
     * @dateType 格式化的类型, date和datetime
     */
    public static String format(Object dateValue, String dateType) {
        if (dateValue == null)
            return "";
        if (dateValue instanceof java.sql.Date) {
            return dateValue.toString();
        } else if (dateValue instanceof Date) {
            if (dateType.equals(TYPE_DATE)) {
                SimpleDateFormat sfdate = new SimpleDateFormat(
                        FORMAT_DATE);
                return sfdate.format(dateValue);
            } else if (dateType.equals(TYPE_DATETIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_DATETIME);
                return sftime.format(dateValue);
            } else if (dateType.equals(TYPE_DATE_TIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_DATE_TIME);
                return sftime.format(dateValue);
            } else if (dateType.equals(TYPE_TIME)) {
                SimpleDateFormat sftime = new SimpleDateFormat(
                        FORMAT_TIME);
                return sftime.format(dateValue);
            } else {
                return "非法日期格式[" + dateType + "]";
            }
        } else {
            return "非日期类型";
        }
    }


    /**
     * 获取优惠券的开始结束时间
     * 前面设置0：00 后面的时间设置成23:59:59秒
     *
     * @param date 需要处理的时间
     * @param type 开始0还是结束1
     * @return 最终上传的时间
     */
    public static String couponFormat(Date date, int type) {
        String dateString = getFormatShortDate(date);
        if (type == TYPE_BEGIN) {
            return dateString + " 00:00:00";
        } else {
            return dateString + " 23:59:59";
        }
    }

    /**
     * 秒速转时分秒格式
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
//                if (hour > 99)
//                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * ONE_HOUR_SECONDS - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    /**
     * 秒速转时分秒格式
     *
     * @param time
     * @return
     */
    public static String secToDayTime(int time) {
        String timeStr = null;
        int day = 0;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00分00秒";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + "分" + unitFormat(second) + "秒";
            } else {
                hour = minute / 60;
                if (hour < 24) {
                    minute = (time / 60) % 60;
                    second = time % 60;
                    timeStr = unitFormat(hour) + "时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
                } else {
                    day = (time / 86400) % 24;
                    hour = (time / ONE_HOUR_SECONDS) % 24;
                    minute = (time / 60) % 60;
                    second = time % 60;
                    timeStr = day + "天" + unitFormat(hour) + "时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
                }
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }


    /**
     * 得到 HH:mm:ss的时间从毫秒输里面
     *
     * @param msec 毫秒数
     * @return 格式化后的时间
     */
    public static String getLeftFormatTimeFromMsec(long msec) {
        StringBuilder stringBuilder = new StringBuilder();
        long timeSecond = msec / 1000;
        long hour = timeSecond / ONE_HOUR_SECONDS;
        long minute = (timeSecond % ONE_HOUR_SECONDS) / 60;
        long second = timeSecond % 60;
        stringBuilder.append(getAlignNumber(hour) + ":" + getAlignNumber(minute) + ":" + getAlignNumber(second));
        return stringBuilder.toString();
    }

    /**
     * 得到 mm:ss的时间从毫秒输里面
     *
     * @param msec 毫秒数
     * @return 格式化后的时间
     */
    public static String getLeftMinuteSecondsFromMsec(long msec) {
        StringBuilder stringBuilder = new StringBuilder();
        long timeSecond = msec / 1000;
        long minute = timeSecond / ONE_MINUTE_SECONDS;
        long second = timeSecond % 60;
        stringBuilder.append(getAlignNumber(minute) + ":" + getAlignNumber(second));
        return stringBuilder.toString();
    }

    /**
     * 从秒数得到小时数
     *
     * @param sec 秒数
     */
    public static long getHourFromMsec(long sec) {
        long hour = sec / ONE_HOUR_SECONDS;
        return hour;
    }

    /**
     * 从秒数得到分钟数
     *
     * @param sec 秒数
     */
    public static long getMinuteFromMsec(long sec) {
        long minute = sec % ONE_HOUR_SECONDS / ONE_MINUTE_SECONDS;
        return minute;
    }

    /**
     * 得到去除 时 分 之后的秒数
     *
     * @param sec 秒数
     */
    public static long getLeavedSecondFromMsec(long sec) {
        long seconds = sec % ONE_MINUTE_SECONDS;
        return seconds;
    }

    /**
     * 获取到多少天多少小时多少
     *
     * @param msec 毫秒数
     * @return 格式化后的时间：2天2小时0分
     */
    public static String getDayHourMinTimeFromMsec(long msec) {
        StringBuilder stringBuilder = new StringBuilder();
        long timeSecond = msec / 1000;
        long hour = timeSecond / ONE_HOUR_SECONDS;
        long day = hour / 24;
        long minute = (timeSecond % ONE_HOUR_SECONDS) / 60;
        long second = timeSecond % 60;
        //1天以内，写X小时X分。1天以上，写X天X小时
        if (day > 0) {
            stringBuilder.append(day).append("天");
            stringBuilder.append(hour);
        } else if (day < 0) {
            //时间异常
            stringBuilder.append("0天");
        } else {
            //多少小时
            if (hour > 0) {
                stringBuilder.append(hour);
            }
            stringBuilder.append(minute).append("分钟");
        }
        return stringBuilder.toString();
    }

    /**
     * 自动补0的方法
     *
     * @param number 数字
     * @return 返回结果字符串 例如 number为10 返回10 如果为9那就返回09
     */
    public static String getAlignNumber(long number) {
        if (number >= 10) {
            return "" + number;
        } else {
            return "0" + number;
        }
    }

    /**
     * 判断时间是否在此之后[有效]
     *
     * @param time 时间
     * @return
     */
    public static boolean isValid(long time) {
        long timeNow = new Date().getTime();
        return time - timeNow > 0;
    }

    /**
     * 判断是否在该小时后
     *
     * @param targetHour 目标时间
     * @return
     */
    public static boolean isAfterHour(int targetHour) {
        Calendar cal = Calendar.getInstance();// 当前日期
        int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
        int minute = cal.get(Calendar.MINUTE);// 获取分钟
        int minuteOfDay = hour * 60 + minute;// 从0:00分开是到目前为止的分钟数
        if (hour >= targetHour) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否同一天
     *
     * @param date 判断的日期
     * @return
     */
    public static boolean isToday(Date date) {
        return getFormatShortDate(date).equals(getFormatShortDate(new Date()));
    }

    /**
     * 判断时间是否在此之后[有效]
     *
     * @param date 时间
     * @return
     */
    public static boolean isValid(String date) {
        long time = DateUtil.getDate(date).getTime();
        long timeNow = new Date().getTime();
        return time - timeNow > 0;
    }

    /**
     * 判断时间是否在此之后[有效]
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 结束时间在开始时间后面即为有效 返回true
     */
    public static boolean isValid(Date beginDate, Date endDate) {
        return endDate.getTime() - beginDate.getTime() > 0;
    }

    /**
     * date2比date1多的天数
     * 只是通过日期来进行比较两个日期的相差天数的比较，没有精确到相差到一天的时间。如果是只是纯粹通过日期（年月日）来比较比较的话
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            //同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    //闰年
                    timeDistance += 366;
                } else {
                    //不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            //不同年
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * 是通过计算两个日期相差的毫秒数来计算两个日期的天数差的。当他们相差是23个小时的时候，它就不算一天了
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * ONE_HOUR_SECONDS * 24));
        return days;
    }

    /**
     * @return date
     */
    public static Date getDateFromFormat(String date) {
        return getDateFromFormat(date, FORMAT_DATETIME);
    }

    /**
     * @return date
     */
    public static Date getDateFromFormat(String date, String FORMAT_DATETIME) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATETIME);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getFormatShortDate1(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        String dateString = formatter.format(date);
//        ParsePosition pos = new ParsePosition(8);
//        Date currentTime_2 = formatter.parse(dateString, pos);
        Date currentTime_2 = null;
        try {
            currentTime_2 = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentTime_2;
    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDate0(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date datetime = formatter.parse(dateString, pos);
        java.sql.Timestamp ts = null;
        if (datetime != null) {
            ts = new java.sql.Timestamp(datetime.getTime());
        }
        return ts.toString();
    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        return formatter.format(date);
    }

    /**
     * 获取短格式类型的Date
     */
    public static String getFormatDate(Date date, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        return formatter.format(date);
    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDateAppendStartStatus(Date date) {
        return getFormatShortDate(date) + " 00:00:00";
    }

    /**
     * 获取短格式类型的Date
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static String getFormatShortDateAppendEndStatus(Date date) {
        return getFormatShortDate(date) + " 23:59:59";
    }

    public static Date getFormatShortDate2() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date datetime = formatter.parse(dateString, pos);
        java.sql.Timestamp ts = null;
        if (datetime != null) {
            ts = new java.sql.Timestamp(datetime.getTime());
        }
        return ts;
    }

    /**
     * 获取时间戳
     *
     * @param date 当前的时间
     * @return 时间戳 "timestamp":"2017-07-08 12:12:12.123"
     */
    public static String getTimestamp(Date date) {
        return sformat3.format(date);
    }

    /**
     * "2018-02-09 13:44"转为 02-09\n2018
     *
     * @param dateString 需要处理的时间
     * @return 显示在列表中的年月日格式的时间
     */
    public static String getItemYearMonthDay(String dateString) {
        String[] split = dateString.split(" ");
        if (split.length > 1) {
            String[] split1 = split[0].split("-");
            StringBuilder stringBuilder = new StringBuilder();
            if (split1.length > 2) {
                stringBuilder.append(split1[1]).append("-").append(split1[2]).append("\n").append(split1[0]);
            } else {
                stringBuilder.append("");
            }
            return stringBuilder.toString();
        } else {
            return "";
        }
    }
}

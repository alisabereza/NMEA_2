package Services;

import Entities.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils<T extends NmeaString> {
    public static <T> void NmeaParser(String string) {
        String[] subStr;
        String delimiter = ",";
        subStr = string.split(delimiter);
        subStr[0] = subStr[0].substring(1);
        subStr[subStr.length - 1] = subStr[subStr.length - 1].substring(0, subStr[subStr.length - 1].indexOf("*"));

        try {
            String className = "Entities." + subStr[0];
            Class clazz = Class.forName(className);

            T message = (T) clazz.newInstance();
            Method methodSetNew = message.getClass().getDeclaredMethod("setNew", String[].class);
            methodSetNew.invoke(message, new Object[]{subStr});
            Method methodShow = message.getClass().getDeclaredMethod("show");
            methodShow.invoke(message);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static int stringToInt(String s) {
        int number = s.equals("") ? 0 : Integer.parseInt(s);
        return number;
    }

    public static Double stringToDouble(String s) {
        double number = s.equals("") ? 0.0 : Double.parseDouble(s);
        return number;
    }

    public static java.sql.Time stringToTime(String s) throws ParseException {
        String s1 = splitTime(s, ":");
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        java.util.Date d = (java.util.Date) sdf.parse(s1);
        java.sql.Time t = new java.sql.Time(d.getTime());
        return t;
    }

    public static String splitTime(String s, String separator) {
        String time = s.equals("") ? "" : s.substring(0, 2) + separator + s.substring(2, 4) + separator + s.substring(4);
        return time;
    }

    public static Date stringToDate(String s) throws ParseException {
        String s1 = splitTime(s, "/");
        DateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
        java.util.Date d2 = (java.util.Date) sdf2.parse(s1);
        java.sql.Date t2 = new java.sql.Date(d2.getDate());
        Date date = sdf2.parse(sdf2.format(d2));
        return date;
    }

    public static char stringToChar(String s) {
        char s1 = s.equals("") ? '-' : s.charAt(0);
        return s1;
    }

}

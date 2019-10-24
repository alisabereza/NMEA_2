package Entities;

import Services.Utils;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

public class GNRMC extends NmeaString {
    private Time timeStamp;
    private char validity;
    private double latitude;
    private char northSouth;
    private double longtitude;
    private char eastWest;
    private double speed;
    private double truCourse;
    private Date dateStamp;
    private double magneticVariation;
    private char eastWest2;
    private String[] fields = {
            "NMEA Title                   ",
            "Time Stamp                   ",
            "Validity - A-ok, V-invalid   ",
            "Current Latitude, North/South",
            "Current Longitude, East/West ",
            "Speed in knots               ",
            "True course                  ",
            "Date Stamp                   ",
            "Magnetic variation, East/West"};

    public GNRMC(String[] str) throws ParseException {
        super.setNmeaTitle(str[0]);
        this.timeStamp = Utils.stringToTime(str[1]);
        this.validity = Utils.stringToChar(str[2]);
        this.latitude = Utils.stringToDouble(str[3]);
        this.northSouth = Utils.stringToChar(str[4]);
        this.longtitude = Utils.stringToDouble(str[5]);
        this.eastWest = Utils.stringToChar(str[6]);
        this.speed = Utils.stringToDouble(str[7]);
        this.truCourse = Utils.stringToDouble(str[8]);
        this.dateStamp = Utils.stringToDate(str[9]);
        this.magneticVariation = Utils.stringToDouble(str[10]);
        this.eastWest2 = Utils.stringToChar(str[11]);
    }

    @Override
    public void show() {
        System.out.println(fields[0] + ": " + super.getNmeaTitle());
        System.out.println(fields[1] + ": " + timeStamp);
        System.out.println(fields[2] + ": " + validity);
        System.out.println(fields[3] + ": " + latitude + ", " + northSouth);
        System.out.println(fields[4] + ": " + longtitude + ", " + eastWest);
        System.out.println(fields[5] + ": " + speed);
        System.out.println(fields[6] + ": " + truCourse);
        System.out.println(fields[7] + ": " + dateStamp);
        System.out.println(fields[8] + ": " + magneticVariation + ", " + eastWest2);
    }
}

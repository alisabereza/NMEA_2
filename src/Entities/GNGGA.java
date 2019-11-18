package Entities;

import Services.Utils;

import java.sql.Time;
import java.text.ParseException;

public class GNGGA extends NmeaString<GNGGA> {
    private Time time;
    private double latitude;
    private char northSouth;
    private double longtitude;
    private char eastWest;
    private int gpsQualityIndicator;
    private int numberOfSatellites;
    private double hDOP;
    private double altitude;
    private char altMeasure;
    private double height;
    private char heighMeasure;
    private Time timeSinceLastUpdate;
    private int dGPSReferenceStation;
    private String[] fields = {
            "NMEA Title                                                  ",
            "Time                                                        ",
            "Latitude                                                    ",
            "Longitude                                                   ",
            "GPS Quality indicator (0=no fix, 1=GPS fix, 2=Dif. GPS fix) ",
            "Number of Satellites                                        ",
            "Horizontal Dilution of Precision (HDOP)                     ",
            "Altitude:                                                   ",
            "Height of geoid above WGS84 ellipsoid                       ",
            "Time since last DGPS update                                 ",
            "DGPS reference station id                                   "};


    @Override
    public void show() {
        System.out.println(fields[0] + ": " + super.getNmeaTitle());
        System.out.println(fields[1] + ": " + time);
        System.out.println(fields[2] + ": " + latitude + ", " + northSouth);
        System.out.println(fields[3] + ": " + longtitude + ", " + eastWest);
        System.out.println(fields[4] + ": " + gpsQualityIndicator);
        System.out.println(fields[5] + ": " + numberOfSatellites);
        System.out.println(fields[6] + ": " + hDOP);
        System.out.println(fields[7] + ": " + altitude + ", " + altMeasure);
        System.out.println(fields[8] + ": " + height + ", " + heighMeasure);
        System.out.println(fields[9] + ": " + timeSinceLastUpdate);
        System.out.println(fields[10] + ": " + dGPSReferenceStation);
    }

    @Override
    public void setNew(String[] str) throws ParseException {
        super.setNmeaTitle(str[0]);
        this.time = Utils.stringToTime(str[1]);
        this.latitude = Utils.stringToDouble(str[2]);
        this.northSouth = Utils.stringToChar(str[3]);
        this.longtitude = Utils.stringToDouble(str[4]);
        this.eastWest = Utils.stringToChar(str[5]);
        this.gpsQualityIndicator = Utils.stringToInt(str[6]);
        this.numberOfSatellites = Utils.stringToInt(str[7]);
        this.hDOP = Utils.stringToDouble(str[8]);
        this.altitude = Utils.stringToDouble(str[9]);
        this.altMeasure = Utils.stringToChar(str[10]);
        this.height = Utils.stringToDouble(str[11]);
        this.heighMeasure = Utils.stringToChar(str[12]);
        if (!str[13].equals("")) {
            this.timeSinceLastUpdate = Utils.stringToTime(str[13]);
        }
        ;
        this.dGPSReferenceStation = (str[14].equals("")) ? 0 : Utils.stringToInt(str[14]);
        ;
    }
}

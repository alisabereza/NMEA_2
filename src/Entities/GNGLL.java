package Entities;

import Services.Utils;
import java.text.ParseException;
import java.util.Date;

public class GNGLL extends NmeaString {
    private double latitude;
    private char direction1;
    private double longtitude;
    private char direction2;
    private Date date;
    private char status;
    private char posSysModIndicator = '-';
    private String[] fields = {
            "NMEA Title                                                           ",
            "Latitude (DDmm.mm) + direction (N = North, S = South)                ",
            "Longitude (DDDmm.mm) + direction (E = East, W = West)                ",
            "UTC time status of position (hours/minutes/seconds/decimal seconds)  ",
            "Data status: A = Data valid, V = Data invalid                        ",
            "Positioning system mode indicator                                    "};

    public GNGLL(String[] str) throws ParseException {
        super.setNmeaTitle(str[0]);
        this.latitude = Utils.stringToDouble(str[1]);
        this.direction1 = Utils.stringToChar(str[2]);
        this.longtitude = Utils.stringToDouble(str[3]);
        this.direction2 = Utils.stringToChar(str[4]);
        this.date = Utils.stringToDate(str[5]);
        this.status = Utils.stringToChar(str[6]);
        if (str.length == 8) {
            this.posSysModIndicator = Utils.stringToChar(str[str.length - 1]);
        }

    }

    @Override
    public void show() {
        System.out.println(fields[0] + ": " + super.getNmeaTitle());
        System.out.println(fields[1] + ": " + latitude + ", " + direction1);
        System.out.println(fields[2] + ": " + longtitude + ", " + direction2);
        System.out.println(fields[3] + ": " + date);
        System.out.println(fields[4] + ": " + status);
        System.out.println(fields[5] + ": " + posSysModIndicator);
    }
}

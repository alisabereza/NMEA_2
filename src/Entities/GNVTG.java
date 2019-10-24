package Entities;

import Services.Utils;

import java.util.ArrayList;
import java.util.List;

public class GNVTG extends NmeaString {
    private double trueTrack;
    private char ttMadeGood;
    private double magneticTrack;
    private char mtMadeGood;
    private double speedNots;
    private char knots;
    private double speedKmH;
    private char km;
    private String[] fields = {
            "NMEA Title                        ",
            "True track made good              ",
            "Magnetic track made good          ",
            "Ground speed, knots               ",
            "Ground speed, Kilometers per hour "};

    public GNVTG(String[] str) {
        super.setNmeaTitle(str[0]);
        this.trueTrack = Utils.stringToDouble(str[1]);
        this.ttMadeGood = Utils.stringToChar(str[2]);
        this.magneticTrack = Utils.stringToDouble(str[3]);
        this.mtMadeGood = Utils.stringToChar(str[4]);
        this.speedNots = Utils.stringToDouble(str[5]);
        this.knots = Utils.stringToChar(str[6]);
        this.speedKmH = Utils.stringToDouble(str[7]);
        this.km = Utils.stringToChar(str[8]);
    }

    @Override
    public void show() {
        List stringFields = new ArrayList();
        stringFields.add(super.getNmeaTitle());
        stringFields.add(trueTrack);
        stringFields.add(ttMadeGood);
        stringFields.add(magneticTrack);
        stringFields.add(mtMadeGood);
        stringFields.add(speedNots);
        stringFields.add(knots);
        stringFields.add(speedKmH);
        stringFields.add(km);
        System.out.println(fields[0] + ": " + stringFields.get(0));
        for (int i = 1; i < fields.length; i++) {
            System.out.println(fields[i] + ": " + stringFields.get(2 * i - 1) + ", " + stringFields.get(2 * i));
        }
    }
}

package Entities;

import Services.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GNGSA extends NmeaString<GNGSA> {
    private char mode1;
    private int mode2;
    private int svID1;
    private int svID2;
    private int svID3;
    private int svID4;
    private int svID5;
    private int svID6;
    private int svID7;
    private int svID8;
    private int svID9;
    private int svID10;
    private int svID11;
    private int svID12;
    private double pDOP;
    private double hDOP;
    private double vDOP;
    private String[] fields = {
            "NMEA Title                                                         ",
            "Mode (M=Manual, forced to operate in 2D or 3D, A=Automatic, 3D/2D) ",
            "Mode (1=Fix not available, 2=2D, 3=3D)                             ",
            "ID of SV used in position fix (null for unused fields)             ",
            "PDOP                                                               ",
            "HDOP                                                               ",
            "VDOP                                                               "};


    @Override
    public void show() {
        List stringFields = new ArrayList();
        stringFields.add(super.getNmeaTitle());
        stringFields.add(mode1);
        stringFields.add(mode2);
        stringFields.add(svID1);
        stringFields.add(svID2);
        stringFields.add(svID3);
        stringFields.add(svID4);
        stringFields.add(svID5);
        stringFields.add(svID6);
        stringFields.add(svID7);
        stringFields.add(svID8);
        stringFields.add(svID9);
        stringFields.add(svID10);
        stringFields.add(svID11);
        stringFields.add(svID12);
        stringFields.add(pDOP);
        stringFields.add(hDOP);
        stringFields.add(vDOP);
        for (int i = 0; i < 3; i++) {
            System.out.println(fields[i] + ": " + stringFields.get(i));
        }
        for (int i = 3; i <= 14; i++) {
            System.out.println(fields[3] + ": " + stringFields.get(i));
        }
        for (int i = 15; i < 18; i++) {
            System.out.println(fields[i - 11] + ": " + stringFields.get(i));
        }
    }

    @Override
    public void setNew(String[] str) {
        super.setNmeaTitle(str[0]);
        this.mode1 = Utils.stringToChar(str[1]);
        this.mode2 = Utils.stringToInt(str[2]);
        this.svID1 = Utils.stringToInt(str[3]);
        this.svID2 = Utils.stringToInt(str[4]);
        this.svID3 = Utils.stringToInt(str[5]);
        this.svID4 = Utils.stringToInt(str[6]);
        this.svID5 = Utils.stringToInt(str[7]);
        this.svID6 = Utils.stringToInt(str[8]);
        this.svID7 = Utils.stringToInt(str[9]);
        this.svID8 = Utils.stringToInt(str[10]);
        this.svID9 = Utils.stringToInt(str[11]);
        this.svID10 = Utils.stringToInt(str[12]);
        this.svID11 = Utils.stringToInt(str[13]);
        this.svID12 = Utils.stringToInt(str[14]);
        this.pDOP = Utils.stringToDouble(str[15]);
        this.hDOP = Utils.stringToDouble(str[16]);
        this.vDOP = Utils.stringToDouble(str[17]);
    }
}

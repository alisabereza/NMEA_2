package Entities;

import Services.Utils;

import java.util.ArrayList;
import java.util.List;

public class GPGSV extends NmeaString {
    private int numberOfMessagesInCycle;
    private int messageNumber;
    private int svsInView;
    private int sv1PrnNumber;
    private int sv2PrnNumber;
    private int sv3PrnNumber;
    private int sv4PrnNumber;
    private int sv1Elevation;
    private int sv2Elevation;
    private int sv3Elevation;
    private int sv4Elevation;
    private int sv1Azimuth;
    private int sv2Azimuth;
    private int sv3Azimuth;
    private int sv4Azimuth;
    private int sv1SNR;
    private int sv2SNR;
    private int sv3SNR;
    private int sv4SNR;
    private String[] fields = {
            "NMEA Title                                             ",
            "Total number of messages of this type in this cycle    ",
            "Message number                                         ",
            "Total number of SVs in view                            ",
            "SV PRN number                                       ",
            "Elevation in degrees, 90 maximum                    ",
            "Azimuth, degrees from true north, 000 to 359        ",
            "SNR, 00-99 dB (null when not tracking               "};

    public GPGSV(String[] str) {
        super.setNmeaTitle(str[0]);
        this.numberOfMessagesInCycle = Utils.stringToInt(str[1]);
        this.messageNumber = Utils.stringToInt(str[2]);
        this.svsInView = Utils.stringToInt(str[3]);
        this.sv1PrnNumber = Utils.stringToInt(str[4]);
        this.sv2PrnNumber = Utils.stringToInt(str[8]);
        this.sv3PrnNumber = Utils.stringToInt(str[12]);
        this.sv4PrnNumber = Utils.stringToInt(str[16]);
        this.sv1Elevation = Utils.stringToInt(str[5]);
        this.sv2Elevation = Utils.stringToInt(str[9]);
        this.sv3Elevation = Utils.stringToInt(str[13]);
        this.sv4Elevation = Utils.stringToInt(str[17]);
        this.sv1Azimuth = Utils.stringToInt(str[6]);
        this.sv2Azimuth = Utils.stringToInt(str[10]);
        this.sv3Azimuth = Utils.stringToInt(str[14]);
        this.sv4Azimuth = Utils.stringToInt(str[18]);
        this.sv1SNR = Utils.stringToInt(str[7]);
        this.sv2SNR = Utils.stringToInt(str[11]);
        this.sv3SNR = Utils.stringToInt(str[15]);
        this.sv4SNR = Utils.stringToInt(str[19]);

    }

    @Override
    public void show() {
        List stringFields = new ArrayList();
        stringFields.add(super.getNmeaTitle());
        stringFields.add(numberOfMessagesInCycle);
        stringFields.add(messageNumber);
        stringFields.add(svsInView);
        stringFields.add(sv1PrnNumber);
        stringFields.add(sv1Elevation);
        stringFields.add(sv1Azimuth);
        stringFields.add(sv1SNR);
        stringFields.add(sv2PrnNumber);
        stringFields.add(sv2Elevation);
        stringFields.add(sv2Azimuth);
        stringFields.add(sv2SNR);
        stringFields.add(sv3PrnNumber);
        stringFields.add(sv3Elevation);
        stringFields.add(sv3Azimuth);
        stringFields.add(sv3SNR);
        stringFields.add(sv4PrnNumber);
        stringFields.add(sv4Elevation);
        stringFields.add(sv4Azimuth);
        stringFields.add(sv4SNR);

        for (int i = 0; i < 4; i++) {
            System.out.println(fields[i] + ": " + stringFields.get(i));
        }
        for (int i = 0; i < (stringFields.size() - 4) / 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println((i + 1) + "SV " + fields[j + 4] + ": " + stringFields.get(j + 4 * (i + 1)));
            }
        }

    }
}

import Services.Utils;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        Utils.NmeaParser("$GPGSV,3,1,11,03,03,111,00,04,15,270,00,06,01,010,00,13,06,292,00*74");
    }
}

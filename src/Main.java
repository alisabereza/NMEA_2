import Services.Utils;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Utils.NmeaParser("$GPRMC,081836,A,3751.65,S,14507.36,E,000.0,360.0,130998,011.3,E*62");
    }
}

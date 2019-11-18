package Entities;

import java.text.ParseException;

public abstract class NmeaString <T extends NmeaString<T>> {
    private String nmeaTitle;

    public void setNmeaTitle(String nmeaTitle) {
        this.nmeaTitle = nmeaTitle;
    }

    public String getNmeaTitle() {
        return nmeaTitle;
    }

    abstract void show();
    abstract void setNew(String [] strings) throws ParseException;
}
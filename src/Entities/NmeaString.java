package Entities;

public abstract class NmeaString {
    private String nmeaTitle;

    public void setNmeaTitle(String nmeaTitle) {
        this.nmeaTitle = nmeaTitle;
    }

    public String getNmeaTitle() {
        return nmeaTitle;
    }

    abstract void show();
}
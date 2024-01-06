package org.example;

public class DVD extends Item{
    private int duration;
    private final int dvdID;
    public DVD(String title, int duration){
        dvdID = getUniqueID();
        setTitle(title);
        setDuration(duration);
    }
    @Override
    void borrowItem() {
        setBorrowed(true);
    }

    @Override
    void returnItem() {
        setBorrowed(false);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDvdID() {
        return dvdID;
    }
}

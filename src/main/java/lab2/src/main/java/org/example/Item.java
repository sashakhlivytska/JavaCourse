package org.example;

public abstract class Item {
    private String title;
    private static int uniqueID = 0;
    private boolean isBorrowed = false;

    Item()
    {
        uniqueID++;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static int getUniqueID() {
        return uniqueID;
    }

    public static void setUniqueID(int uniqueID) {
        Item.uniqueID = uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    abstract void borrowItem();
    abstract void returnItem();
}

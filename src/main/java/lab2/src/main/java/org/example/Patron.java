package org.example;

import java.util.ArrayList;
import java.util.List;
public class Patron {
    private static int nextId = 1;
    private final int patronId;
    private String name;
    private final List<Item> borrowedItems;

    public Patron(String name) {
        this.patronId = nextId;
        nextId++;
        setName(name);
        borrowedItems = new ArrayList<Item>();
    }

    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void returnItem (Item item)
    {
        borrowedItems.remove(item);
    }
    public void borrowItem(Item item)
    {

        borrowedItems.add(item);
    }
}

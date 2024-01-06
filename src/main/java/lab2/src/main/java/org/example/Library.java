package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library implements IManageable{
    private final List<Item> items;
    private final List<Patron> patrons;
    public Library(){
        items = new ArrayList<Item>();
        patrons = new ArrayList<Patron>();
    }
    @Override
    public void add(Item item)
    {
        items.add(item);
    }
    @Override
    public void remove(Item item)
    {
        items.remove(item);
    }
    @Override
    public void listBorrowed()
    {
        for (Item item:items) {
            if (item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }
    @Override
    public void listAvailable()
    {
        for (Item item:items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }
    public void registerCustomer(Patron patron)
    {
        patrons.add(patron);
    }
    public void lendItem(Patron patron, Item item)
    {
        patron.borrowItem(item);
        item.setBorrowed(true);
    }
    public void returnItem(Patron patron,Item item)
    {
        patron.returnItem(item);
        item.setBorrowed(false);
    }

    public List<Item> getItems()
    {
        return items;
    }
}

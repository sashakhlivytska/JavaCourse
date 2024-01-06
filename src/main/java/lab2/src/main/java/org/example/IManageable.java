package org.example;

public interface IManageable {
    public void add(Item item);
    public void remove(Item item);
    public void listAvailable();
    public void listBorrowed();
}

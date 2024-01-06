package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

class LibraryTest {

    private Library lib;
    private Book book1;
    private Book book2;
    private DVD dvd;
    private Patron patron;
    private List<Item> testItem;

    @BeforeEach
    public void setUp()
    {
        lib = new Library();
        book1 = new Book("CLR via C#","Jeffrey Richter");
        book2 = new Book("Clean Code","Robert Cecil Martin");
        dvd = new DVD("Blu-ray",7);
        patron = new Patron ("Anton");
        testItem = new ArrayList<Item>();

    }

    @Test
    void testAdd() {
        assertEquals(0, lib.getItems().size());
        lib.add(book1);
        assertEquals(1, lib.getItems().size());
        assertTrue(lib.getItems().contains(book1));
    }

    @Test
    void testRemove() {
        lib.add(book1);
        lib.add(book2);
        assertEquals(2,lib.getItems().size());
        lib.remove(book2);
        assertEquals(1,lib.getItems().size());
        assertFalse(lib.getItems().contains(book2));
    }
    @Test
    void testLendItem()
    {
        testItem.add(book1);
        testItem.add(book2);

        lib.lendItem(patron,book1);
        lib.lendItem(patron,book2);

        assertTrue(book1.isBorrowed());
        assertFalse(dvd.isBorrowed());
        assertEquals(testItem,patron.getBorrowedItems());
    }
    @Test
    void testReturnItem()
    {
        testItem.add(book1);

        lib.lendItem(patron,book1);
        lib.lendItem(patron,book2);

        lib.returnItem(patron,book2);

        assertTrue(book1.isBorrowed());
        assertFalse(book2.isBorrowed());

        assertEquals(patron.getBorrowedItems(),testItem);
    }
}
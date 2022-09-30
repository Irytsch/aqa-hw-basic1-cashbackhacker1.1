package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {

    @Test
    public void remainIfAmountEqualBoundary() {
        CashbackHackService service = new CashbackHackService();

        int actual = service.remain(1000);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void remainIfAmountLessBoundary() {
        CashbackHackService service = new CashbackHackService();

        int actual = service.remain(900);
        int expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    public void remainIfAmountMoreBoundary() {
        CashbackHackService service = new CashbackHackService();

        int expected = 400;
        int actual = service.remain(1600);
        assertEquals(expected, actual);
    }
}
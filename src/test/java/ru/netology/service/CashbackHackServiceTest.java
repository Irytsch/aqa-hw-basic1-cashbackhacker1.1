package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CashbackHackServiceTest {

    @Test
    public void remainIfAmountEqualBoundary() {
        CashbackHackService service = new CashbackHackService();

        int actual = service.remain(1000);
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void remainIfAmountLessBoundary() {
        CashbackHackService service = new CashbackHackService();

        int actual = service.remain(900);
        int expected = 100;

        assertEquals(actual, expected);
    }

    @Test
    public void remainIfAmountMoreBoundary() {
        CashbackHackService service = new CashbackHackService();

        int actual = service.remain(1600);
        int expected = 400;

        assertEquals(actual, expected);
    }
}
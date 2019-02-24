package ru.mera.romazanova.task11;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test11 {

    public static void main(String[] args) {
        final RandomDates newrandom = new RandomDates();
        final ArrayList<LocalDate> newMassive = newrandom.createRandomDates();

        // newrandom.getGroupedDatesByCenture(newMassive);
        // newrandom.getDateWhereLastDayOfMonthIsSanday(newMassive);
        // newrandom.sortOfDatesInIncreasingOrder(newMassive);
        // newrandom.changeFormat(newMassive);
    }

}

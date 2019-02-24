package ru.mera.romazanova.task11;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RandomDates {
    final ArrayList<LocalDate> massiveDate = createRandomDates();

    public ArrayList<LocalDate> createRandomDates() {
        final ArrayList<LocalDate> massiveDate = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            final LocalDate randomDate = createRandomDate(1500, 2500);
            massiveDate.add(randomDate);
            // System.out.println(randomDate);
        }
        return massiveDate;
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        final int day = createRandomIntBetween(1, 28);
        final int month = createRandomIntBetween(1, 12);
        final int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    HashMap<Integer, ArrayList<LocalDate>> groupDatesByCenture = new HashMap<>();

    private void add(int centure, LocalDate date) {
        if (!groupDatesByCenture.containsKey(centure)) {
            groupDatesByCenture.put(centure, new ArrayList<LocalDate>());
        }
        groupDatesByCenture.get(centure).add(date);
    }

    public void getGroupedDatesByCenture(ArrayList<LocalDate> massiveDate) {
        for (final LocalDate forIterationOfMassiveDate : massiveDate) {
            add(forIterationOfMassiveDate.getYear() / 100, forIterationOfMassiveDate);
        }

        for (final Map.Entry<Integer, ArrayList<LocalDate>> temp : groupDatesByCenture.entrySet()) {
            System.out.println(temp.getKey() + " centure has dates : ");
            for (final LocalDate tempDate : temp.getValue()) {
                System.out.println(tempDate);
            }
        }

    }

    public void getDateWhereLastDayOfMonthIsSanday(ArrayList<LocalDate> massiveDate) {
        System.out.println(
                "The following dates had (will have) the last day of a month which fell (will have) on a Sunday: ");
        for (final LocalDate forIterationOfMassiveDate : massiveDate) {
            final int year = forIterationOfMassiveDate.getYear();
            final int month = forIterationOfMassiveDate.getMonthValue();
            final int day = forIterationOfMassiveDate.getDayOfMonth();

            final LocalDate lastOfMonth = forIterationOfMassiveDate.with(TemporalAdjusters.lastDayOfMonth());
            // System.out.println("Проверяемое число " + lastOfMonth);
            if (lastOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println(forIterationOfMassiveDate);
            }

        }
    }

    public void sortOfDatesInIncreasingOrder(ArrayList<LocalDate> massiveDate) {
        final ArrayList<LocalDate> tempMassiveForSort = new ArrayList<>(massiveDate);
        Collections.sort(tempMassiveForSort);
        System.out.println("Sorted dates in increasing order :");
        for (final LocalDate temp : tempMassiveForSort) {
            System.out.println(temp);
        }
    }

    public void changeFormat(ArrayList<LocalDate> massiveDate) {
        System.out.println("New format of dates in 1999 year: ");

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        ;
        for (final LocalDate tempDate : massiveDate) {
            final String formattedString = tempDate.format(formatter);
            if (formattedString.endsWith("99")) {
                System.out.println(formattedString);
            }

        }

    }

}

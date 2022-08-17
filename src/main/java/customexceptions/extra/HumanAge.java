package customexceptions.extra;

import customexceptions.exceptions.InvalidEraException;
import customexceptions.exceptions.InvalidMonthException;
import customexceptions.exceptions.InvalidDayException;
import customexceptions.exceptions.InvalidYearException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class HumanAge implements AutoCloseable{
    private int day;
    private int month;
    private int year;
    private String era;
    private static final Logger logger = LogManager.getLogger(HumanAge.class);

    public HumanAge(){}
    public HumanAge(int day, int month, int year,String era) {
        setDay(day);
        setMonth(month);
        setYear(year);
        setEra(era);
    }

    @Override
    public void close() throws Exception {
        logger.info("HumanAge closed.");
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day<=0 || day>31) throw new InvalidDayException("Day number must be between 0 and 31");
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month<=0 || month>12) throw new InvalidMonthException("Month must be between 1 and 12");
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<0) throw new InvalidYearException("Year must be positive");
        this.year = year;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        if(!(era.equalsIgnoreCase("AD") || era.equalsIgnoreCase("BC"))) throw new InvalidEraException("You must use BC or AD");
        this.era = era;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanAge humanAge = (HumanAge) o;
        return day == humanAge.day && month == humanAge.month && year == humanAge.year && Objects.equals(era, humanAge.era);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, era);
    }

    @Override
    public String toString() {
        return "HumanAge{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", era='" + era + '\'' +
                '}';
    }
}

package christmas.model;


import static christmas.utility.Constants.STAR_DAYS;
import static christmas.utility.Constants.WEEKEND;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private Integer visitDate;
    private List<Integer> starDays;

    public Calendar() {
        this.starDays = new ArrayList<>();
        setStarDays();
    }

    public void setVisitDate(Integer visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitDate() {
        return this.visitDate;
    }

    public boolean existStar() {
        if (starDays.contains(this.visitDate)) { return true; }
        return false;
    }

    public boolean isWeekend() {
        if (WEEKEND.contains(this.visitDate)) {
            return true;
        }
        return false;
    }

    private void setStarDays() {
        this.starDays = STAR_DAYS;
    }
}

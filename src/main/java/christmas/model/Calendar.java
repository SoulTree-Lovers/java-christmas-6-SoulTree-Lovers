package christmas.model;


import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private Integer visitDate;
    private List<Integer> starDays;

    public Calendar() {
        this.starDays = new ArrayList<>();
    }

    public void setVisitDate(Integer visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitDate() {
        return visitDate;
    }

    public void setStarDay(List<Integer> starDay) {
        this.starDays = starDay;
    }

    public boolean existStar() {
        if (starDays.contains(visitDate)) { return true; }
        return false;
    }
}

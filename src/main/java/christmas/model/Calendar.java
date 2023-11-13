package christmas.model;


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

    public void setStarDay(List<Integer> starDay) {
        this.starDays = starDay;
    }

    public boolean existStar() {
        if (starDays.contains(this.visitDate)) { return true; }
        return false;
    }

    public boolean isWeekend() {
        List<Integer> weekend = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        if (weekend.contains(this.visitDate)) {
            return true;
        }
        return false;
    }

    private void setStarDays() {
        this.starDays = List.of(3, 10, 17, 24, 25, 31);
    }
}

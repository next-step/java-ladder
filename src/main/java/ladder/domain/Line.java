package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    private static final String CONSECUTIVE_TRUES_CANNOT_BE_ENTERED = "Line을 생성할 때 true가 연속으로 들어올 수 없습니다.";

    public Line(List<Boolean> list) {
        validation(list);
        this.points = list;
    }

    private void validation(List<Boolean> list){
        for (int i = 1; i < list.size(); i++) {
            continuousLineValidation(list, i);
        }
    }

    private void continuousLineValidation(List<Boolean> list, int i) {
        if(list.get(i) == true){
            List<Boolean> consecutiveElements = new ArrayList<>();
            consecutiveElements.add(list.get(i - 1));
            consecutiveElements.add(list.get(i));

            inCaseOfConsecutive(consecutiveElements);
        }
    }

    private static void inCaseOfConsecutive(List<Boolean> areConsecutiveEqual) {
        if (areConsecutiveEqual.get(0) == areConsecutiveEqual.get(1)) {
            throw new IllegalArgumentException(CONSECUTIVE_TRUES_CANNOT_BE_ENTERED);
        }
    }

    public List<Boolean> stream() {
        return this.points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line that = (Line) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}

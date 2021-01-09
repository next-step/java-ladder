package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private static List<Boolean> flagList = new ArrayList<>(Arrays.asList(true, false));
    private List<Boolean> points = new ArrayList<>();

    // TODO 테스트 고민 레이싱 강의 참조
    private boolean createLine(int i) {
        if (i > 0 && points.get(i)) {
            points.add(false);
            return false;
        }
        Collections.shuffle(flagList);
        return flagList.get(0);
    }

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            createLine(i);
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(this.points);
    }
}

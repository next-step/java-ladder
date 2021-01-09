package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private static List<Boolean> flagList = new ArrayList<>(Arrays.asList(true, false));
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            // 사다리 생성 참, 거짓
            Collections.shuffle(flagList);
            points.add(flagList.get(0));
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(this.points);
    }
}

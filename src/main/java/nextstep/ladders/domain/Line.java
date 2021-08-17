package nextstep.ladders.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random random = new Random();
        List<Boolean> temps = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            if (i == 0) {
                temps.add(false);
                continue;
            }
            boolean isLine = random.nextBoolean();
            if (isLine) {
                temps.add(true);
                if (i != countOfPerson - 1) {
                    temps.add(false);
                }
                i++;
            } else {
                temps.add(false);
            }
        }
        this.points = temps;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
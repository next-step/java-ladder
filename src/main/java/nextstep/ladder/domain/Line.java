package nextstep.ladder.domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points;

    public Line(int countOfParticipant) {
        this(new ArrayList<>(countOfParticipant - 1));

        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    public Line(ArrayList<Boolean> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

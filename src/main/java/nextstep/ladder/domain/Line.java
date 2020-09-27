package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Leg> legs = new ArrayList<>();

    public Line(int countOfPersons) {
        if (countOfPersons < 1) {
            throw new IllegalStateException("사다리 타기의 최소 인원 수는 1명 입니다.");
        }
        if (countOfPersons == 1) {
            return;
        }
        legs.add(Leg.random());
    }

    public static Line random(int countOfUsers) {
        Line line = new Line(countOfUsers);

        for (int i = 1; i < countOfUsers - 1; i++) {
            line.addRandomPoint(i);
        }
        return line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + legs +
                '}';
    }

    public List<Leg> getLegs() {
        return legs;
    }

    private void addRandomPoint(int index) {
        Leg beforeLeg = legs.get(index - 1);
        if (beforeLeg.isExist()) {
            legs.add(Leg.ofNotExist());
            return;
        }
        legs.add(Leg.random());
    }

    public boolean isMovableToLeft(int nowCol) {
        if (nowCol - 1 < 0) {
            return false;
        }
        return legs.get(nowCol - 1).isExist();
    }

    public boolean isMovableToRight(int nowCol) {
        int countOfUsers = legs.size() + 1;
        if (nowCol == countOfUsers) {
            return false;
        }
        return legs.get(nowCol).isExist();
    }
}

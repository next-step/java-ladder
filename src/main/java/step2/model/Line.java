package step2.model;

import step2.util.LadderDirection;
import step2.ganerator.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    private Line(Person person, RandomGenerator randomGenerator) {
        IntStream.range(0, person.nameSize()).forEach(i -> createLadderLine(randomGenerator));
    }

    //라인을 생성한다.
    public static Line createLine(Person person, RandomGenerator randomGenerator) {
        return new Line(person, randomGenerator);
    }

    //좌우로 살피고 true인 라인으로 옮긴다.
    public int getLineForward(int i) {
        return LadderDirection.decideDirection(this, i);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int pointSize() {
        return points.size();
    }

    public boolean getLineTrueOrFalse(int i) {
        return points.get(i);
    }

    //사다리 라인을 생성한다.
    private void createLadderLine(RandomGenerator randomGenerator) {
        if (checkLeftLadder() && randomGenerator.randomLadder()) {
            this.points.add(true);
            return;
        }
        this.points.add(false);
    }

    //왼쪽 라인 사다리가 이미 생성이 되어있는지 체크한다.
    private boolean checkLeftLadder() {
        return !points.isEmpty() && !points.get(points.size() - 1);
    }
}

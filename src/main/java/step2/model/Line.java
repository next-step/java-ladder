package step2.model;

import step2.ganerator.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    private Line(String[] personArr, RandomGenerator randomGenerator) {
        IntStream.range(0, personArr.length).forEach(i -> createLadderLine(randomGenerator));
    }

    //라인을 생성한다.
    public static Line createLine(String[] personArr, RandomGenerator randomGenerator) {
        return new Line(personArr, randomGenerator);
    }

    public List<Boolean> getPoints() {
        return points;
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

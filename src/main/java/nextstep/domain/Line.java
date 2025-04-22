package nextstep.domain;

import nextstep.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isPoint(int idx) {
        return points.get(idx);
    }

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            points.add(RandomUtils.nextBoolean());
        }
    }

    public Line(Line previousLine) {
        for (Boolean hasPoint : previousLine.getPoints()) {
            points.add(!hasPoint && RandomUtils.nextBoolean());
        }
    }
}

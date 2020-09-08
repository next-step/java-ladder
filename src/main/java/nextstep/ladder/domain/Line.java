package nextstep.ladder.domain;

import nextstep.ladder.util.LadderUtils;
import nextstep.ladder.util.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(false);
        for (int i = 1; i < countOfPerson; i++) {
            generateBridge(i);
        }
    }

    private void generateBridge(int position) {
        if (!isExistBridge(position)) {
            make(position, RandomUtils.randomBoolean());
            return;
        }
        makeEmptyBridge();

    }

    private boolean isExistBridge(int position) {
        return points.get(position - 1);
    }

    private void make(int position, boolean isGenerate) {
        points.set(position - 1, isGenerate);
        points.add(position, isGenerate);
    }

    private void makeEmptyBridge() {
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        boolean isBridge = points.get(position);
        if (!isBridge) return position;

        if (position == 0) {
            return position + 1;
        }

        if (position == (points.size() - 1)) {
            return position - 1;
        }

        boolean isOpen = isOpen(position);

        if (isOpen) return toLeft(position);

        return toRight(position);
    }

    private boolean isOpen(int position) {
        boolean isOpen = false;
        for (int i = 0; i < position; i++) {
            points.get(i);
            isOpen = LadderUtils.isOpenBridge(isOpen,points.get(i));
        }

        return isOpen;
    }

    private int toLeft(int position) {
        return position - 1;
    }

    private int toRight(int position) {
        return position + 1;
    }

}

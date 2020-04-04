package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean> {
    private int size;
    private List<Boolean> points;
    private RightDirection rightDirection;


    public Line(int size, RightDirection rightDirection) {
        this.size = size;
        this.rightDirection = rightDirection;
        initPoints();
    }

    private void initPoints() {
        points = new ArrayList<>();
        int lastIndex = lastIndex();
        for (int i = 0; i < lastIndex; i++) {
            boolean randomPoint = rightDirection.isAbleToRight();
            if (i != 0 && points.get(i - 1) && randomPoint) {
                randomPoint = false;
            }
            points.add(randomPoint);
        }
        points.add(false);
    }

    public int size() {
        return points.size();
    }

    protected boolean last() {
        return points.get(lastIndex());
    }

    private int lastIndex() {
        return size - 1;
    }


    @Override public Iterator<Boolean> iterator() {
        return points.iterator();
    }
}

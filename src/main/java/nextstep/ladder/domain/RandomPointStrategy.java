package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomPointStrategy implements PointStrategy {

    @Override
    public List<Boolean> point(int widthOfLength) {
        boolean prevPaint = false;
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < widthOfLength; i++) {
            boolean currPaint = Math.random() < 0.5;
            boolean paint = isPaint(prevPaint, currPaint);
            points.add(paint);
            prevPaint = paint;
        }

        return points;
    }

    private boolean isPaint(boolean prev, boolean curr) {
        return !prev && curr;
    }

}

package ladder.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.LadderMessage.LINE_LENGTH_MESSAGE;

public class Line {

    private final int[] points;

    public Line(int countOfPoint) {
        checkArgument(countOfPoint > 0, LINE_LENGTH_MESSAGE);

        points = new int[countOfPoint];
        for (int i = 0; i < points.length; i++) {
            points[i] = i;
        }
    }

    public void drawsFrom(int position) {
        points[position] = position + 1;
        points[position + 1] = position;
    }

    public boolean startsWith(int position) {
        return points[position] == position + 1;
    }

    public int countOfPoint() {
        return points.length;
    }
}

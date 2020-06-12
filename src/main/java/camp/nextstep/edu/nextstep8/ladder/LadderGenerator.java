package camp.nextstep.edu.nextstep8.ladder;

import java.util.Arrays;
import java.util.List;

public class LadderGenerator {

    private final Point[][] map;
    private final int cols;
    private final int height;

    public LadderGenerator(int cols, int height) {
        this.cols = cols;
        this.height = height;
        this.map = init(cols, height);
        make();
    }

    private Point[][] init(int cols, int height) {
        Point[][] ladderMap = new Point[height][cols];
        Arrays.stream(ladderMap)
                .forEach(points -> Arrays.stream(points)
                        .map(point -> new Point()));
        return ladderMap;
    }

    public Ladder make() {
        drawLine(0, 1);
        return new Ladder();
    }

    private boolean isAlreadyDraw(int height, int cols) {
        return map[height][cols].isEnd() || map[height][cols + 1].isStart();
    }

    private boolean meetLastOrder(int now) {
        int next = now + 1;
        if(cols <= next) {
            return true;
        }
        return false;
    }

    private void drawLine(int row, int order) {
        if(meetLastOrder(order)) {
            return;
        }

        if(isAlreadyDraw(row, order)) {
            return;
        }

        map[row][order].markStart();
        map[row][order + 1].markEnd();
    }
}

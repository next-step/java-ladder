package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;
import camp.nextstep.edu.nextstep8.ladder.entity.Point;
import camp.nextstep.edu.nextstep8.ladder.entity.Row;

import java.util.Arrays;
import java.util.List;

public class LadderGenerator {

    public LadderGenerator(List<String> members, int height) {
        // make(members, height);
        // TODO
        // make Rows
        //
        for(int i)
    }

    private Point[][] init(int cols, int rows) {
        Point[][] ladderMap = new Point[rows][cols];
        Arrays.stream(ladderMap)
                .forEach(points -> Arrays.stream(points)
                        .map(point -> new Point()));
        return ladderMap;
    }

    public Ladder make() {
        drawLine(0, 1);
        return new Ladder(this.map);
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

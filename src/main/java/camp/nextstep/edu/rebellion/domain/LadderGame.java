package camp.nextstep.edu.rebellion.domain;

import java.util.List;

public class LadderGame {
    private final int rows;
    private final int cols;

    public LadderGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    // 사다리를 어떤 룰을 이용하여 생성할지 외부에서 결정할 수 있게 한다
    public Ladder make() {
        // 사다리를 다양하게 그리는 방법
        // 1. 시작점을 다르게 한다
        // 2. 그릴 수 있는 곳이지만 안그린다
        Ladder ladder = new Ladder(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols-1; j++) {
                ladder.drawLine(i, j);
            }
        }
        return ladder;
    }

    public void run() {
    }
}

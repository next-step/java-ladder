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
        Ladder ladder = new Ladder(rows, cols);

        return ladder;
    }

    public void run() {
    }
}

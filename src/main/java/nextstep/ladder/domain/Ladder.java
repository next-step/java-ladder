package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder = new ArrayList<>();
    private int height;

    public Ladder(int line, int height) {
        this.height = height;
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(line));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    // 사다리 실행결과도 사다리 클래스 안에 저장되어야 하는가?

}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultLineCreator implements LineCreator{

    private final int ladderHeight;

    public DefaultLineCreator(int ladderHeight) {
        checkLadderHeight(ladderHeight);

        this.ladderHeight = ladderHeight;
    }

    @Override
    public List<Line> createLine(int numberOfPlayers, PointFactory pointFactory) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(numberOfPlayers, pointFactory));
        }

        return lines;
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("높이는 1 이상으로 설정 하세요");
        }
    }
}

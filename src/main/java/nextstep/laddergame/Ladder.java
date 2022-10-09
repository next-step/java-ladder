package nextstep.laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> board;

    Ladder(int width, int height) {
        // 기본 사다리 템플릿 생성
        List<Line> board = getLadderTemplate(width, height);

        // TODO: 가로 다리 생성

        this.board = Collections.unmodifiableList(board);
    }

    public List<Line> getBoard() {
        return board;
    }

    private List<Line> getLadderTemplate(int width, int height) {
        List<Line> ladderTemplate = new ArrayList<>();
        for (int innerIndex = 0; innerIndex < height; innerIndex++) {
            ladderTemplate.add(new Line(width));
        }
        return ladderTemplate;
    }

}

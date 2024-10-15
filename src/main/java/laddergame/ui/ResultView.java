package laddergame.ui;

import laddergame.domain.Line;
import laddergame.domain.Players;

import java.util.List;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행결과";
    private static final String LADDER_HORIZONTAL_LINE = "-";
    private static final String LADDER_VERTICAL_LINE = "|";

    public void showLadderGameResult(Players players, List<Line> ladder) {
        System.out.println(RESULT_START_MESSAGE);

        System.out.println(players.toString());
    }
}

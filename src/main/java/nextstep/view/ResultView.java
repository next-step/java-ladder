package nextstep.view;

import nextstep.domain.ladder.Ladder;
import nextstep.domain.line.Line;
import nextstep.domain.line.Point;
import nextstep.domain.player.Players;

public class ResultView {
    private static final String BLANK = " ";
    private static final String WALL = "|";
    private static final String LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final int MAX_NAME_LENGTH = 6;

    public static void getLadderView(Players players, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        System.out.println();

        getPlayersName(players);
        getLadderResult(ladder);
    }

    private static void getPlayersName(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String name: players.getPlayerNames()) {
            appendBlankName(stringBuilder, name);
            stringBuilder.append(name);
        }
        System.out.println(stringBuilder);
    }

    private static void getLadderResult(Ladder ladder) {
        ladder.getAllLines()
                .forEach(ResultView::getLineResult);
    }

    private static void getLineResult(Line line){
        System.out.print(EMPTY_LINE);
        line.getPoints().forEach(point ->
            System.out.print(WALL+ isLineOrBlank(point)));
        System.out.println(WALL);
    }

    private static String isLineOrBlank(Point point){
        if(point.isConnected()) {
            return LINE;
        }
        return EMPTY_LINE;
    }

    private static void appendBlankName(StringBuilder stringBuilder, String name){
        stringBuilder.append(BLANK.repeat(MAX_NAME_LENGTH - name.length()));
    }
}

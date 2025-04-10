package nextstep.ladder.ui;

import nextstep.ladder.Ladder;
import nextstep.ladder.player.Entries;

public class ResultView {
    public static final String HORIZONTAL_LINE = "-----";
    public static final String VERTICAL_LINE = "|";
    public static final String EMPTY_SPACE = "     ";

    public static void printLadder(Ladder ladder, Entries results) {
        System.out.println("실행 결과\n");
        System.out.print(ladder);
        System.out.println(results);
    }
}

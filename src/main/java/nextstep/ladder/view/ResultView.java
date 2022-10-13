package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEW_LINE + "실행결과" + NEW_LINE;

    public static void showLadder(LadderResult result) {
        System.out.println(RESULT_MESSAGE);

        result.playerNames()
                .forEach(name -> {
                    System.out.printf("%6s", name);
                });
        System.out.println();
        result.lines()
                .forEach(System.out::println);
    }

    private ResultView() {
    }
}

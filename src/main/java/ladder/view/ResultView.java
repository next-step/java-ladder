package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Point;

public class ResultView {
    private static final String MESSAGE_RESULT = "실행결과";
    private static final String CONNECT = "-----|";
    private static final String DIS_CONNECT = "     |";

    private ResultView() {
    }

    public static void printParticipantNames(Player player) {
        System.out.println(MESSAGE_RESULT);
        player.getNames().stream()
            .map(name -> String.format("%6s", name))
            .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(line -> {
            line.getPoint().stream()
                .map(Point::toBoolean)
                .forEach(point -> System.out.print(point ? CONNECT : DIS_CONNECT));
            System.out.println();
        });
    }
}

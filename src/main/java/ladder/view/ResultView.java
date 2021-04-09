package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.MatchResult;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Point;
import ladder.domain.Prize;

public class ResultView {
    private static final String MESSAGE_RESULT = "실행결과";
    private static final String CONNECT = "-----|";
    private static final String DIS_CONNECT = "     |";

    private ResultView() {
    }

    public static void printPlayerNames(Players players) {
        System.out.println(MESSAGE_RESULT);
        players.getPlayers().stream().forEach(player -> {
            System.out.print(String.format("%6s", player.getPlayerName()));
        });
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

    public static void printMatchOfPrize(Prize prize) {
        System.out.println(prize.getPrize());
    }

    public static void printAllMatchOfPrize(MatchResult matchResult) {
        System.out.println(MESSAGE_RESULT);
        matchResult.getMatchResult().forEach(ResultView::printMatchResult);
    }

    private static void printMatchResult(Player player, Prize prize) {
        System.out.println(String.format("%s : %s", player, prize.getPrize()));
    }
}

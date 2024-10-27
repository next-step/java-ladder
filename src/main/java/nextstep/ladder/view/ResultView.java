package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Link;
import nextstep.ladder.domain.Player;

import java.util.List;

public class ResultView {
    private static final String LINK_MARK = "-".repeat(5);
    private static final String EMPTY_LINK_MARK = " ".repeat(5);
    private static final String LINK_SEPARATOR = "|";

    public static void printPlayers(List<Player> people) {
        System.out.print("\n사다리 결과\n\n");
        people.forEach(player -> System.out.printf("%6s", player.getName()));

        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder ladderMark = new StringBuilder();
        ladder.getLines()
                .forEach(line -> ladderMark.append(EMPTY_LINK_MARK)
                        .append(LINK_SEPARATOR)
                        .append(getLadderLineMark(line))
                        .append("\n"));

        System.out.print(ladderMark);
    }

    public static void printPrizes(List<String> prizes) {
        prizes.forEach(prize -> System.out.printf("%-6s", prize));
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println("\n실행결과");
    }

    public static void printPrizeWithPlayer(String playerName, String prize) {
        System.out.println(playerName + " : " + prize);
    }

    public static void printPrize(String prize) {
        System.out.println(prize);
    }

    private static StringBuilder getLadderLineMark(Line line) {
        StringBuilder ladderLineMark = new StringBuilder();

        line.getLinks()
                .forEach(link -> ladderLineMark.append(getLadderLinkMark(link))
                        .append(LINK_SEPARATOR));

        return ladderLineMark;
    }

    private static String getLadderLinkMark(Link link) {
        if (link.isExist()) {
            return LINK_MARK;
        }

        return EMPTY_LINK_MARK;
    }
}

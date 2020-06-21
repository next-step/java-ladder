package laddergame.view;

import laddergame.domain.game.Prize;
import laddergame.domain.game.Prizes;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_JOIN_DELIMITER = "  ";
    private static final String PILLAR = "|";
    private static final String BRIDGE_CONNECT = "-----";
    private static final String BRIDGE_DISCONNECT = "     ";

    private OutputView() {
    }

    public static void printPlayers(Players players) {
        System.out.println("실행 결과");

        System.out.println(String.join(NAME_JOIN_DELIMITER, players.getPlayerNames()));
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(OutputView::printLine);
    }

    public static void printPrizes(Prizes prizes) {
        System.out.println(prizes.getPrizes().stream()
                .map(Prize::getName)
                .collect(Collectors.joining(NAME_JOIN_DELIMITER)));
    }

    private static void printLine(Line line) {
        System.out.println(line.getLineStates().stream()
                .map(OutputView::mappingBridge)
                .collect(Collectors.joining(PILLAR, PILLAR, PILLAR)));
    }

    private static String mappingBridge(boolean isConnected) {
        if (isConnected) {
            return BRIDGE_CONNECT;
        }

        return BRIDGE_DISCONNECT;
    }

    public static void printResult(final Prize prize) {
        System.out.println("실행 결과");
        System.out.println(prize.getName());
    }


    public static void printAllResult(final Map<String, Prize> results) {
        results.forEach((key, value) -> System.out.println(key + " : " + value.getName()));
    }
}

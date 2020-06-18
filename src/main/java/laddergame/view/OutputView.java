package laddergame.view;

import laddergame.domain.game.Result;
import laddergame.domain.game.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_JOIN_DELIMITER = "  ";
    private static final String PILLAR = "|";
    private static final String BRIDGE_CONNECT = "-----";
    private static final String BRIDGE_DISCONNECT = "     ";

    private OutputView() {
    }

    public static void printLadder(Players players, Ladder ladder, Results results) {
        System.out.println("실행 결과");

        System.out.println(players.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.joining(NAME_JOIN_DELIMITER)));

        ladder.getLines()
                .forEach(OutputView::printLine);

        System.out.println(results.getResults().stream()
                .map(Result::getName)
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

}

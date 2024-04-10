package ladder.view;

import ladder.domain.*;
import ladder.domain.vo.Rows;
import ladder.service.LadderGame;

import java.util.Map;

public class OutputView {

    private static final int LADDER_ENDPOINT_WIDTH = 5;

    public static void printLadder(Ladder ladder){
        System.out.println("사다리 결과");

        printPlayers(ladder.players());

        ladder.ladderBody().rowsList()
                .forEach(OutputView::printRows);

        printDestinations(ladder.destinations());
    }

    public static void printResults(Map<Player, Destination> playersDestinations){
        System.out.println("실행 결과");
        playersDestinations.forEach(
                (player, destination) -> System.out.println(player.name() + " : " + destination.result())
        );
    }

    private static void printPlayers(Players players){
        players.players()
                .forEach(player ->
                        System.out.print(formatLadderEndpoint(player.name()))
                );
        System.out.println();
    }

    private static void printDestinations(Destinations destinations){
        destinations.destinations()
                .forEach(destination ->
                        System.out.print(formatLadderEndpoint(destination.result()))
                );
        System.out.println();
    }

    private static StringBuilder formatLadderEndpoint(String value) {
        int spacesLeft = (LADDER_ENDPOINT_WIDTH - value.length()) / 2;
        int spacesRight = LADDER_ENDPOINT_WIDTH - value.length() - spacesLeft;

        StringBuilder formattedEndpoint = new StringBuilder();
        formattedEndpoint.append(" ".repeat(Math.max(spacesLeft, 0)));
        formattedEndpoint.append(value);
        formattedEndpoint.append(" ".repeat(Math.max(spacesRight, 0)));

        return formattedEndpoint;
    }

    private static void printRows(Rows rows) {
        StringBuilder rowsString = new StringBuilder("  |");
        rows.rows().forEach(row -> {
            if (row.bridgeExist()) {
                rowsString.append("----|");
                return;
            }
            rowsString.append("    |");
        });

        System.out.println(rowsString);
    }
}

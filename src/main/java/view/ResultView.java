package view;

import domain.Ladder;
import domain.Ladders;
import domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BOUNDARY_LADDER = "|";

    private static final String NOT_CONNECTED_LINE = "     ";

    private static final String CONNECTED_LINE = "-----";

    private static final String SPACE = "%5s";

    public static void viewResult(Players players, Ladders ladders) {
        System.out.println("실행 결과\n");
        viewPlayers(players);
        viewLadders(ladders);
    }

    private static void viewLadders(Ladders ladders) {
        System.out.println(ladders.getLadders()
                .stream()
                .map(ResultView::convertLadder)
                .collect(Collectors.joining("\n")));
    }

    private static String convertLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(SPACE, BOUNDARY_LADDER))
                .append(convertLines(ladder.getLines()))
                .append(BOUNDARY_LADDER);

        return sb.toString();
    }

    private static String convertLines(List<Boolean> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> line == Boolean.FALSE ? NOT_CONNECTED_LINE : CONNECTED_LINE)
                .collect(Collectors.joining(BOUNDARY_LADDER));
    }

    private static void viewPlayers(Players players) {
        System.out.println(players.getPlayers()
                .stream()
                .map(player -> String.format(SPACE, player.toString()))
                .collect(Collectors.joining(" ")));
    }
}

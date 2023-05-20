package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class ResultView {

    public static final String NAME_FORMAT = "%6s";
    public static final String PILLAR = "|";
    public static final String CONNECTED_LINE = "-----";
    public static final String NOT_CONNECTED_LINE = "     ";
    public static final String BUFFER = "     ";

    public void printLadder(Ladder ladder, Players players) {
        System.out.println("[실행 결과]\n");
        printPlayerNames(players);
        ladder.getRows().stream()
                .forEach(row -> printRow(row));
    }

    private void printPlayerNames(Players players) {
        String nameStr = players.getPlayers().stream()
                        .map(player -> String.format(NAME_FORMAT, player.getName()))
                        .collect(Collectors.joining());
        System.out.println(nameStr);
    }

    private void printRow(LadderRow row) {
        String rowStr = row.getLines().stream()
                .map(line -> convertToString(line))
                .collect(Collectors.joining(PILLAR));
        System.out.println(BUFFER + PILLAR + rowStr + PILLAR);
    }

    private String convertToString(Boolean line) {
        if (line) {
            return CONNECTED_LINE;
        }
        return NOT_CONNECTED_LINE;
    }
}

package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.PlayerGroup;

import java.util.stream.Collectors;

public class ResultView {

    public static final String NAME_FORMAT = "%6s";
    public static final String PILLAR = "|";
    public static final String CONNECTED_LINE = "-----";
    public static final String NOT_CONNECTED_LINE = "     ";
    public static final String FIRST_WHITE_SPACE= "     ";

    public void printLadder(Ladder ladder, PlayerGroup playerGroup) {
        System.out.println("[실행 결과]\n");
        printPlayerNames(playerGroup);
        ladder.getRows()
                .stream()
                .forEach(row -> printRow(row));
    }

    private void printPlayerNames(PlayerGroup playerGroup) {
        String playerNames = playerGroup.getPlayerNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .collect(Collectors.joining());
        System.out.println(playerNames);
    }

    private void printRow(LadderRow ladderRow) {
        String rowString = ladderRow.getLines()
                .stream()
                .map(line -> convertToString(line))
                .collect(Collectors.joining(PILLAR));
        System.out.println(FIRST_WHITE_SPACE + PILLAR + rowString + PILLAR);
    }

    private String convertToString(Boolean line) {
        if (line) {
            return CONNECTED_LINE;
        }
        return NOT_CONNECTED_LINE;
    }
}

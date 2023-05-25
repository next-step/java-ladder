package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.PlayerGroup;
import ladder.domain.ResultGroup;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String NAME_FORMAT = "%-6s";
    private static final String PILLAR = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String NOT_CONNECTED_LINE = "     ";
    private static final String FIRST_WHITE_SPACE= "     ";

    public void printLadder(Ladder ladder, PlayerGroup playerGroup) {
        System.out.println("사다리 결과\n");
        printPlayerNames(playerGroup);
        ladder.getRows()
                .stream()
                .forEach(row -> printRow(row));
    }

    private void printPlayerNames(PlayerGroup playerGroup) {
        String playerNames = convertToString(playerGroup.getPlayerNames());
        System.out.println(playerNames);
    }

    public void printResultGroup(ResultGroup resultGroup) {
        String resultGroups = convertToString(resultGroup.getResultNames());
        System.out.println(resultGroups);
    }

    private String convertToString(List<String> list) {
        return list.stream()
                .map(string -> String.format(NAME_FORMAT, string))
                .collect(Collectors.joining());
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

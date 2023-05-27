package ladder.view;

import ladder.domain.*;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResult;
import ladder.domain.ladder.LadderRow;
import ladder.domain.player.Player;
import ladder.domain.player.PlayerGroup;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {

    private static final String NAME_FORMAT = "%-6s";
    private static final String PILLAR = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String NOT_CONNECTED_LINE = "     ";
    private static final String FIRST_WHITE_SPACE= "   ";
    private static final Player ALL_USER = new Player("all");
    private static final Scanner SCANNER = new Scanner(System.in);

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

    public void printResultGroup(WinningCategories winningCategories) {
        String resultGroups = convertToString(winningCategories.getResultNames());
        System.out.println(resultGroups);
    }

    public void printResult(WinningCategories winningCategories, PlayerGroup playerGroup, LadderResult ladderResult) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        Player player = new Player(SCANNER.nextLine());

        System.out.println("\n실행결과");
        if (ALL_USER.equals(player)) {
            printAllPlayerResult(winningCategories, playerGroup, ladderResult);
            return;
        }
        System.out.println(winningCategories.find(ladderResult.get(player)).toString());
        this.printResult(winningCategories, playerGroup, ladderResult);
    }

    private void printAllPlayerResult(WinningCategories winningCategories, PlayerGroup playerGroup, LadderResult ladderResult) {
        playerGroup.getPlayerList()
                        .stream()
                        .forEach(player ->
                            System.out.printf("%s : %s\n", player.name(), winningCategories.find(ladderResult.get(player)).toString())
                        );

//        ladderResult.keyStream()
//                .forEach(player ->
//                    System.out.printf("%s : %s\n", player.name(), winningCategories.find(ladderResult.get(player)).toString())
//                    System.out.printf("%s : %s\n", player.name(), winningCategories.find(ladderResult.get(player)).toString())
//                );
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

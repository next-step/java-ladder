package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    public static final String NAME_FORMAT = "%6s";
    public static final String PILLAR = "|";
    public static final String CONNECTED_LINE = "-----";
    public static final String NOT_CONNECTED_LINE = "     ";
    public static final String BUFFER = "     ";
    public static final String ALL_SEARCHKEY = "all";

    public void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println("[사다리 결과]\n");
        printPlayerNames(players);
        ladder.getRows().stream()
                .forEach(row -> printRow(row));
        printPrizeNames(prizes);
    }

    private void printPlayerNames(Players players) {
        String nameStr = players.getPlayers().stream()
                        .map(player -> String.format(NAME_FORMAT, player.getName()))
                        .collect(Collectors.joining());
        System.out.println(nameStr);
    }

    private void printPrizeNames(Prizes prizes) {
        String nameStr = prizes.getPrizes().stream()
                .map(prize -> String.format(NAME_FORMAT, prize.getName()))
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

    public void printResult(Result result, String searchKey) {
        System.out.println("[실행 결과]");
        if (searchKey.equals(ALL_SEARCHKEY)) {
            printAllResult(result);
            return;
        }
        printResultForKey(result, searchKey);
    }

    private void printAllResult(Result result) {
        result.getMatchingResult().entrySet().stream()
                .forEach(entry -> System.out.println(String.format("%s : %s", entry.getKey().getName(), entry.getValue().getName())));
    }

    private void printResultForKey(Result result, String searchKey) {
        System.out.println(result.searchPlayer(searchKey));
    }
}

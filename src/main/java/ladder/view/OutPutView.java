package ladder.view;

import ladder.domain.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OutPutView {
    private OutPutView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    private static final String LADDER_CONNECTION_SUCCESS_DELIMITER = "-";
    private static final String LADDER_CONNECTION_FALE_DELIMITER = " ";
    private static final String LADDER_HEIGHT = "|";
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 5;

    public static void outputGame(Lines lines, PlayerNames playerNames, WinResults winResults) {
        List<Line> lines1 = lines.getLines();

        outputPlayerNames(playerNames);
        lines1.stream()
                .forEach(line -> {
                    String newline = "";
                    List<Boolean> isLineConnect = line.getLine();

                    newline = firstLadder();
                    newline += LADDER_HEIGHT;
                    newline += isLineConnect.stream()
                            .map(aBoolean -> {
                                String delimiter = aBoolean ? LADDER_CONNECTION_SUCCESS_DELIMITER : LADDER_CONNECTION_FALE_DELIMITER;
                                String height = LADDER_HEIGHT;
                                return IntStream.range(START_RANGE, END_RANGE)
                                        .mapToObj(i -> delimiter)
                                        .collect(Collectors.joining()) + height;
                            })
                            .collect(Collectors.joining());
                    System.out.println(newline);
                });

        outputResult(winResults);
    }

    public static void outputPlayerNames(PlayerNames playerNames) {
        String playerNamesString = playerNames.getPlayerNames()
                .stream()
                .map(playerName -> playerName.getName())
                .collect(Collectors.joining(" "));

        System.out.println(playerNamesString);
    }

    public static String firstLadder() {
        return IntStream.range(START_RANGE, END_RANGE)
                .mapToObj(i -> LADDER_CONNECTION_FALE_DELIMITER)
                .collect(Collectors.joining());
    }

    public static void outputResult(WinResults winResults) {
        String playerNamesString = winResults.getWinResults()
                .stream()
                .collect(Collectors.joining(" "));

        System.out.println(playerNamesString);
    }

    public static void outPutWinResult(Player player, WinResults winResults) {
        System.out.println("실행결과");
        System.out.println(player.getPlayerName().trim() + " : " + winResults.searchWinResult(player).trim());
    }

    public static void outPutWinResults(Players players, WinResults winResults) {
        System.out.println("실행결과");
        players.getPlayers()
                .forEach(player -> System.out.println(player.getPlayerName().trim() + " : " + winResults.searchWinResult(player).trim()));
    }
}

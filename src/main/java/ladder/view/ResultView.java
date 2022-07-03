package ladder.view;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.engine.LineCreator;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printResultPlayer(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayerName playerName : players.getPlayers().keySet()) {
            stringBuilder.append(playerName).append(" ");
        }
        System.out.println("실행 결과\n\n" + stringBuilder.toString());

    }

    public static void printResult(List<? extends LineCreator> LineCreators) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LineCreator lineCreator : LineCreators) {
            printLines(stringBuilder, lineCreator);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printLines(StringBuilder stringBuilder, LineCreator lineCreator) {
        for (Boolean connectingLines : lineCreator.getConnectingLines()) {
            stringBuilder.append("|");
            if (connectingLines) {
                stringBuilder.append("------");
                continue;
            }
            stringBuilder.append("      ");
        }
        stringBuilder.append("|\n");
    }

    public static String allPlayerResult(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<PlayerName, String> playerMap = players.getPlayers();
        for (PlayerName playerName : playerMap.keySet()) {
            stringBuilder.append(playerName).append(" : ").append(playerMap.get(playerName)).append("\n");
        }
        return stringBuilder.toString();
    }
}

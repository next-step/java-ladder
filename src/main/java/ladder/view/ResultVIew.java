package ladder.view;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.ResultRecord;

import java.util.List;

public class ResultVIew {
    private static final String PLAY_RESULT = "사다리 결과\n";
    private static final String GAME_RESULT = "실행 결과\n";
    private static final String LINES = "-----";
    private static final String STICK = "|";
    private static final String EMPTY_LINES = "     ";
    private static final String COLON = " : ";
    private static final String ONE_SPACE_BAR = " ";
    private static final String ENTER = "\n";
    private static final String ALL = "all";
    private static final int NAME_SPACE = 6;

    private static StringBuilder stringBuilder;

    public static void printLadder(List<String> peopleNames, List<Line> lines) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(PLAY_RESULT);

        peopleNames.forEach(ResultVIew::printName);
        stringBuilder.append(ENTER);

        lines.forEach(line -> printLine(line.getPoints()));
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "");
        System.out.println(stringBuilder.toString());
    }

    public static void printResults(List<String> results) {
        stringBuilder = new StringBuilder();
        results.forEach(ResultVIew::printName);
        System.out.println(stringBuilder.toString());
    }

    public static void printAllResultOfPlayer(ResultRecord resultRecord) {
        stringBuilder = new StringBuilder(GAME_RESULT);
        resultRecord.getResultOfPlayers().forEach(resultOfPlayer -> {
            stringBuilder.append(resultOfPlayer.getPlayerName());
            stringBuilder.append(COLON);
            stringBuilder.append(resultOfPlayer.getResult());
            stringBuilder.append(ENTER);
        });
        System.out.println(stringBuilder.toString());
    }

    public static void printResultOfPlayer(ResultRecord resultRecord, String playerName) {
        stringBuilder = new StringBuilder(GAME_RESULT);
        stringBuilder.append(resultRecord.find(playerName).getResult());
        System.out.println(stringBuilder.toString());
    }

    private static void printName(String name) {
        for (int idx = 0; idx < NAME_SPACE - name.length(); idx++) {
            stringBuilder.append(ONE_SPACE_BAR);
        }
        stringBuilder.append(name);
    }

    private static void printLine(List<Direction> points) {
        points.forEach(v -> {
            if (v.isLeft()) {
                stringBuilder.append(LINES);
            } else {
                stringBuilder.append(EMPTY_LINES);
            }
            stringBuilder.append(STICK);
        });
        stringBuilder.append(ENTER);
    }
}

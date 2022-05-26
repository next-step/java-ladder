package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {

    private static final String GAME_RESULT_MESSAGE = "실행결과";
    private static final String NOT_EMPTY_POINT = "-----";
    private static final String EMPTY_POINT = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String DELIMITER_BETWEEN_NAME_AND_RESULT = " : ";
    private static final int VERTICAL_LINE_WIDTH = 1;
    private static final int POINT_WIDTH = 5;


    public static void printLadderResult(List<Player> players, Ladder ladder, List<LadderResult> ladderResults){
        Output.printNames(players);
        Output.printLadder(ladder);
        Output.printLadderResults(ladderResults);
    }

    public static void printNames(List<Player> players){
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            sb.append(getBlank(POINT_WIDTH + VERTICAL_LINE_WIDTH - player.getName().length()));
            sb.append(player.getName());
        }

        System.out.println(sb);
    }


    private static String getBlank(int cnt) {
        return " ".repeat(Math.max(0, cnt));
    }

    public static void printLadder(Ladder ladder){
        ladder.getLines()
                .forEach(Output::printLine);
    }

    public static void printLine(Line line){
        List<Boolean> points  = line.getPoints();

        String result = points.stream()
                .limit(points.size())
                .map(Output::getPointAndVertical)
                .collect(Collectors.joining(VERTICAL_LINE));

        System.out.println(result);
    }

    private static String getPointAndVertical(boolean point){
        if(point){
            return NOT_EMPTY_POINT ;
        }
        return EMPTY_POINT ;
    }

    public static void printLadderResults(List<LadderResult> ladderResults) {
        StringBuilder sb = new StringBuilder();

        for (LadderResult ladderResult : ladderResults) {
            String value = ladderResult.getValue();
            sb.append(getBlank(POINT_WIDTH + VERTICAL_LINE_WIDTH - value.length()));
            sb.append(value);
        }

        System.out.println(sb);
    }

    public static void printAllGameResults(Map<Player, LadderResult> gameResults) {
        System.out.println(GAME_RESULT_MESSAGE);
        gameResults.entrySet()
                .forEach(Output::printNameAndResult);
    }

    private static void printNameAndResult(Map.Entry<Player, LadderResult> entry){
        Player player = entry.getKey();
        LadderResult ladderResult = entry.getValue();
        System.out.println(String.join(DELIMITER_BETWEEN_NAME_AND_RESULT, player.getName(), ladderResult.getValue()));
    }

    public static void printGameResultByPlayerName(LadderResult result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result.getValue());
    }
}

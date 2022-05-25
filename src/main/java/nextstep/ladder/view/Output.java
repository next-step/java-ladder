package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String NOT_EMPTY_POINT = "-----";
    private static final String EMPTY_POINT = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final int VERTICAL_LINE_WIDTH = 1;
    private static final int POINT_WIDTH = 5;

    public static void printNameList(List<Player> players){
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
}

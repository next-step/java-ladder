package nextstep.ladder.view;

import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Players;
import java.util.List;

public class ResultView {

    public static final String LADDER_WALL = "ㅣ";
    public static final String LADDER_POINT = "-----";
    public static final String LADDER_BLANK = "     ";

    public static void show(List<Line> ladderLines, Players players) {
        players.forEach(name -> System.out.print(appendBlank(name)));
        System.out.println();
        ladderLines.forEach(ResultView::points);
    }

    private static String appendBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);

        while (nameBuilder.length() < Person.MAX_NAME_LENGTH) {
            nameBuilder.append(" ");
        }

        return nameBuilder.toString();
    }


    private static void points(Line ladderLine) {
        System.out.print(LADDER_WALL);
        for (boolean point : ladderLine.points()) {
            if (point) {
                System.out.print(LADDER_POINT);
            } else {
                System.out.print(LADDER_BLANK);
            }
            System.out.print(LADDER_WALL);
        }

        System.out.println();
    }


    public static void result(LadderResult ladderResult, String name) {
        System.out.println("실행결과");
        System.out.println(ladderResult.resultByName(name));
    }

    public static void results(LadderResult ladderResult, Players players) {
        System.out.println("전체결과");
        players.forEach(name ->
            System.out.println(name + " : " + ladderResult.resultByName(name))
        );

    }
}

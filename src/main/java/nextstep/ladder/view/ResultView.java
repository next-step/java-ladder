package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.player.Name;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import java.util.List;

public class ResultView {

    public static final String LADDER_WALL = "ㅣ";
    public static final String LADDER_POINT = "-----";
    public static final String LADDER_BLANK = "     ";

    public static void show(List<Line> ladderLines, Players players) {
        players.foreach(name -> System.out.print(appendBlank(name)));
        System.out.println();
        ladderLines.forEach(ResultView::points);
    }

    private static String appendBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);

        while (nameBuilder.length() < Name.MAX_NAME_LENGTH) {
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


    public static void result(LadderResult ladderResult, Player player) {
        System.out.println("실행결과");
        System.out.println(ladderResult.result(player));
    }

    public static void results(LadderResult ladderResult, Players players) {
        System.out.println("전체결과");
        players.values(player ->
            System.out.println(player.name() + " : " + ladderResult.result(player))
        );

    }
}

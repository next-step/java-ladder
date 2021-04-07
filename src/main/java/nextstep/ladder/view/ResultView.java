package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.view.dto.LadderDto;
import nextstep.ladder.view.dto.PlayerNamesDto;

public class ResultView {

    private static final String END_LINE = "|";
    private static final String CONNECTED = "|-----";
    private static final String NOT_CONNECTED = "|     ";

    private ResultView() {
    }

    public static void showPlayers(PlayerNamesDto players) {
        for (String name : players.names()) {
            System.out.print(name);
        }
        System.out.println();
    }

    public static void showLadder(LadderDto ladderDto) {
        ladderDto.lines()
                .forEach(ResultView::showLine);
    }

    private static void showLine(Line line) {
        line.readOnlyPoints()
                .stream()
                .map(ResultView::convertPoint)
                .forEach(System.out::print);
        System.out.println(END_LINE);
    }

    private static String convertPoint(Point point) {
        return point.isConnected() ? CONNECTED : NOT_CONNECTED;
    }
}

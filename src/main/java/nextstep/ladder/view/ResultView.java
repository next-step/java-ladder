package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public final class ResultView {

    private final static String PIN = "|";
    private final static String POINT = "-----";
    private final static String EMPTY_POINT = "     ";
    private final static String TAB = "\t";
    private final static String NEW_LINE = System.lineSeparator();

    private ResultView() { }

    private static void printLadderTitle() {
        enter();
        System.out.println("사다리 결과");
    }

    private static void printResultTitle() {
        enter();
        System.out.println("실행 결과");
    }

    public static void printLadder(Ladder ladder) {
        printLadderTitle();
        printPlayers(ladder.getPlayers());

        List<Line> lines = ladder.getLines().toList();
        lines.forEach(line -> {
            System.out.print(TAB + PIN);
            line.toList().forEach(point -> System.out.print(getPointPin(point)));
            enter();
        });
    }

    private static void printPlayers(Players players) {
        players.toList().forEach(player -> System.out.print(player.getName() + TAB));
        enter();
    }

    private static String getPointPin(Point point) {
        return (point.hasPoint() ? POINT : EMPTY_POINT) + PIN;
    }

    public static void printRewords(Rewords rewords) {
        rewords.toList().forEach(reword -> System.out.print(reword + TAB));
        enter();
    }

    public static void printPlayerResult(Player player, Result result) {
        printResultTitle();
        System.out.println(result.get(player));
        enter();
    }

    public static void printAllPlayerResult(Result result) {
        printResultTitle();
        result.toMap().keySet()
                .forEach(player -> System.out.println(player.getName() + " : " + result.get(player)));
        enter();
    }

    private static void enter() {
        System.out.println();
    }
}

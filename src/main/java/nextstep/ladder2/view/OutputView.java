package nextstep.ladder2.view;

import nextstep.ladder2.ladder.Ladder;
import nextstep.ladder2.player.Player;
import nextstep.ladder2.player.Players;
import nextstep.ladder2.result.Results;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BLANK = "    ";
    private static final String LADDER = "----";
    private static final String LINE = "|";

    public static void viewInit(Players players, Ladder ladder, Results results) {
        show(players);
        drawLine(ladder);
        show(results);
    }

    private static void show(Players players) {
        String result = players.names().stream()
                .map(OutputView::LPad)
                .collect(Collectors.joining());
        System.out.println(result);

    }

    private static void drawLine(Ladder ladder) {
        ladder.lines().stream()
                .forEach(line -> System.out.println(BLANK + lineDrawer(line.showLine())));
    }

    private static void show(Results results) {
        String result = results.resultValues().stream()
                .map(OutputView::LPad)
                .collect(Collectors.joining());
        System.out.println(result);
    }

    public static String ListToString(List<String> list) {
        String result = "";
        for (String item : list) {
            result += item;
        }
        return result;
    }

    public static String lineDrawer(List<Boolean> lines) {
        return LINE + lines.stream()
                .map(OutputView::booleanToLadderLine)
                .collect(Collectors.joining(LINE))
         + LINE;
    }

    public static String booleanToLadderLine(boolean line) {
        return line ? LADDER : BLANK;
    }

    public static String LPad(String s) {
        if ("".equals(s)) {
            s = " ";
        }
        while (s.length() < 5) {
            s = " " + s;
        }
        return s;
    }

    public static void showResult(Players players, Results results, String name) {
        if (!players.names().contains(name)) {
            System.out.println(String.format("플레이어 이름 목록에 없는 이름입니다.(%s)", name));
        }
        System.out.println("실행 결과");
        System.out.println(results.findResult(players.findPosition(name)));
    }

    public static void showAllResult(Players players, Results results) {
        System.out.println("실행 결과");
        players.stream()
                .forEach(
                        player -> System.out.println(String.format("%s : %s",player.name(), results.findResult(player.index())))
                );
    }
}

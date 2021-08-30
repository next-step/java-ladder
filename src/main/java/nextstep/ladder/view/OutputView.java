package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final int MAX_STR_SIZE = 6;
    private static final String LINE = "-----";
    private static final String BLANK = "     ";

    public static void showResult(Ladder ladder) {

        showNames(ladder.getNames());
        showLadders(ladder.getLines());
    }

    public static void showNames(List<String> names) {
        names.stream()
                .map(OutputView::LPadding)
                .forEach(System.out::print);
        System.out.println();
    }

    public static String LPadding(String str) {
        while (str.length() < MAX_STR_SIZE) {
            str = " " + str;
        }
        return str;
    }

    private static void showLadders(List<Line> lines) {
        lines.stream()
                .map(Line::getList)
                .map(OutputView::booleanToLine)
                .map(OutputView::stringLine)
                .forEach(System.out::println);
    }

    public static List<String> booleanToLine(List<Boolean> statusList) {
        return statusList.stream()
                .map(OutputView::booleanToLine)
                .collect(Collectors.toList());
    }

    public static String booleanToLine(boolean status) {
        return status ? LINE : BLANK;
    }
    public static String stringLine(List<String> lines){
        return lines.stream()
                .collect(Collectors.joining( "|", BLANK +"|", "|"));
    }

}

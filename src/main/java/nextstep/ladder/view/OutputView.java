package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final int MAX_STR_SIZE = 6;
    private static final String TRUE = "-----";
    private static final String FALSE = "     ";

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
                .map(line -> "     " + line)
                .forEach(System.out::println);
    }

    public static List<String> booleanToLine(List<Boolean> statusList) {
        return statusList.stream()
                .map(OutputView::booleanToLine)
                .collect(Collectors.toList());
    }

    public static String booleanToLine(boolean status) {
        return status ? TRUE : FALSE;
    }
    public static String stringLine(List<String> lines){
        String result = "|";
        // 해당부분을 스트림으로 처리 하는 방법을 모르겠습니다....
        for(String line : lines){
            result += line;
            result += "|";
        }
        return result;
    }

}

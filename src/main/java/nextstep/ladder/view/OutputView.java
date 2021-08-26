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
                .forEach(name -> System.out.print(LPadding(name)));
        System.out.println();
    }

    public static String LPadding(String str) {
        while (str.length() < MAX_STR_SIZE) {
            str = " " + str;
        }
        return str;
    }

    private static void showLadders(List<Line> lines) {
        lines.stream().
                map(Line::getList)
                .map(line -> booleanToLine(line))
                .forEach(line -> System.out.println("     "+stringLine(line)));
    }

    public static List<String> booleanToLine(List<Boolean> statusList) {
        return statusList.stream()
                .map(v -> booleanToLine(v))
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

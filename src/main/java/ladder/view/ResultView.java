package ladder.view;

import java.util.List;

public class ResultView {

    private static final String RESULT_OPENING_MESSAGE = "실행 결과";
    private static final String LADDER_PRINT_MARGIN = "   ";
    private static final String LADDER_DIVIDER = "|";
    private static final String IS_HORIZONTAL = "-----";
    private static final String IS_NOT_HORIZONTAL = "     ";

    public static void printResultOpening() {
        System.out.println(RESULT_OPENING_MESSAGE);
    }

    public static void printUsers(List<String> users) {
        for (String user : users) {
            System.out.printf("%.5s", user);
        }
    }

    public static void printLadder(List<List<Boolean>> layout) {
        for (List<Boolean> line : layout) {
            printLine(line);
        }
    }

    private static void printLine(List<Boolean> line) {
        System.out.print(LADDER_PRINT_MARGIN);
        for (Boolean status : line) {
            System.out.print(LADDER_DIVIDER);
            printPart(status);
        }
        System.out.println(LADDER_DIVIDER);
    }

    private static void printPart(Boolean status) {
        String part = status ? IS_HORIZONTAL : IS_NOT_HORIZONTAL;
        System.out.print(part);
    }
}

package ladder.view;

import java.util.Scanner;

public class ResultView {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static String enterAttendees() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

    public static void printLadderResult(final String ladderResult) {
        System.out.println("실행 결과");
        System.out.println(ladderResult);
    }

}

package ladder.view;

import java.util.Scanner;

public class InputView {
    public static final String USER_COUNT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String HEIGHT_QUESTION = "최대 사다리 높이는 몇 개인가요?";
    public static final String LADDER_GOALS_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String LADDER_WINNER_QESTION = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public static String askNumberOfUser() {
        System.out.println(USER_COUNT_QUESTION);
        return scanner.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(HEIGHT_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String askLadderGoals() {
        System.out.println(LADDER_GOALS_QUESTION);
        return scanner.nextLine();
    }

    public static String askLadderWinner() {
        System.out.println(LADDER_WINNER_QESTION);
        return new Scanner(System.in).nextLine();
    }

}

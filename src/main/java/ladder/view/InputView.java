package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    protected static String enterParticipants() {
        String ENTER_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        System.out.println(ENTER_PARTICIPANTS);
        return scanner.nextLine();
    }

    protected static int enterMaxLadderHeight() {
        System.out.println();
        String ENTER_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
        System.out.println(ENTER_MAX_LADDER_HEIGHT);
        int height = scanner.nextInt();
        deleteOpeningLetter();
        return height;
    }

    protected static String enterLadderGameResult() {
        System.out.println();
        String ENTER_LADDER_GAME_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        System.out.println(ENTER_LADDER_GAME_RESULT);
        return scanner.nextLine();
    }

    public static String enterName() {

        System.out.println();
        String ENTER_NAME = "결과를 보고 싶은 사람은?";
        System.out.println(ENTER_NAME);
        return scanner.nextLine();
    }

    private static void deleteOpeningLetter() {
        scanner.nextLine();
    }
}

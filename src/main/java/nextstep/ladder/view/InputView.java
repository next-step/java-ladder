package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PEOPLES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_GIFTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";

    public static String inputPeoples() {
        System.out.println(INPUT_PEOPLES_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputGifts() {
        System.out.println(INPUT_GIFTS_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static String inputResultName() {
        System.out.println(INPUT_RESULT_NAME_MESSAGE);
        return scanner.nextLine();
    }
}

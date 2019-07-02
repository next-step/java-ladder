package ladder;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static Scanner scanner;


    public static String inputPlayersName() {
        System.out.println(INPUT_NAME_MESSAGE);
        scanner = new Scanner(System.in);
        String playersNames = scanner.nextLine();
        return playersNames;

    }


    public static int inputLadderHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        return height;
    }
}

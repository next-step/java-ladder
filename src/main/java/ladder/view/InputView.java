package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String INPUT_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static String INPUT_LADDER_WANT_NAME = "결과를 보고 싶은 사람은?";


    public static String inputNames() {
        System.out.println(INPUT_NAMES);
        return scanner.nextLine();
    }

    public static String inputLadderResult(){
        System.out.println(INPUT_LADDER_RESULT);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        int returnValue = scanner.nextInt();
        scanner.nextLine();
        return returnValue;
    }

    public static String wantNameToResult(){
        System.out.println(INPUT_LADDER_WANT_NAME);
        return scanner.nextLine();
    }
}
package nextstep.ladder.ui;

import nextstep.ladder.exception.MisMatchNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String PRINTLN_PERSON_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRINTLN_LADDER_PRIZE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PRINTLN_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String PRINTLN_LADDER_RESULT_NAME = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String personName() {
        System.out.println(PRINTLN_PERSON_NAME);
        return scanner.next();
    }

    public static String ladderPrize() {
        System.out.println();
        System.out.println(PRINTLN_LADDER_PRIZE);
        return scanner.next();
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println(PRINTLN_LADDER_HEIGHT);
        int manualLottoCount = inputNumber();
        scanner.nextLine();
        return manualLottoCount;
    }

    public static String inputLadderResultName() {
        System.out.println();
        System.out.println();
        System.out.println(PRINTLN_LADDER_RESULT_NAME);
        return scanner.next();
    }

    private static int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new MisMatchNumberException();
        }
    }

}

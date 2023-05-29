package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printPersonInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderHeightInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?.");
    }

    public static void printResultsInput() {
        System.out.println("실행 결과를 입력하세요. (결과를 쉼표(,)로 구분하세요)");
    }

    public static void printPersonResultInput() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static int intInput() {
        return scanner.nextInt();
    }

    public static String stringInput() {
        return scanner.next();
    }
}

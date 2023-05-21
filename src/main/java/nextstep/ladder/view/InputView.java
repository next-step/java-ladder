package nextstep.ladder.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static String showUserNamesConsole() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static int showLadderHeightConsole() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String showExecuteResultsConsole() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static String showUserResultConsole() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

}

package camp.nextstep.edu.rebellion.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getPlayers() {
        System.out.println("참여할 사람 이름을 입력해주세요 (쉽표로 구분) ");
        return getLine();
    }

    public static int getRows() {
        System.out.println("최대 사다리 높이를 입력해 주세요 ");
        return getInt();
    }

    public static String getPlayerOrCommandForResult() {
        System.out.println("결과를 보고싶은 참여자를 입력해 주세요 (전체보기 : all) ");
        return getLine();
    }

    private static int getInt() {
        if (SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다");
    }

    private static String getLine() {
        if (SCANNER.hasNextLine()) {
            return SCANNER.next().trim();
        }
        throw new IllegalArgumentException("입력 값이 없습니다");
    }
}

package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputPerson() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return SCANNER.nextLine().split(COMMA);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.", e);
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다", e);
        }
    }

    public static String[] inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            return SCANNER.nextLine().split(COMMA);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.", e);
        }
    }

    private static String[] trim(String[] results) {
        for (String result : results) {
            result.trim();
        }
        return results;
    }

    public static String inputPlayerWhoWantGetResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        try {
            return SCANNER.next();

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.", e);
        }
    }
}

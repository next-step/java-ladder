package step3_renewal.view;

import java.util.Scanner;

public class InputUi {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nameOfParticipate() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.next();
    }

    public static int maximumHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static String inputExecutionResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.next();
    }

    public static String wantToSeeResult(){
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.next();
    }

    public static void close() {
        SCANNER.close();
    }
}

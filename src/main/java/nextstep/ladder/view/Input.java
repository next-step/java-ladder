package nextstep.ladder.view;

import java.util.Scanner;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String InputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static int InputCountOfLine() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int countOfLine = SCANNER.nextInt();
        SCANNER.nextLine();
        return countOfLine;
    }

    public static String InputCompensation() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static String InputParticipantWantResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}

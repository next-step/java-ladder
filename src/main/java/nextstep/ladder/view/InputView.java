package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String initPeople() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        return sc.nextLine();
    }

    public static String excutionResult() {
        System.out.println("실행 결과를 입력하세요.");
        return sc.nextLine();
    }

    public static int maxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return sc.nextInt();
    }

    public static String resultName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.next();
    }

}

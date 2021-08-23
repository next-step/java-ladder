package nextstep.view;


import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String insertPlayer() {

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return scanner.next();
    }

    public static int insertLadderHeight() {

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String insertRewardResult() {

        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}

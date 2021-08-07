package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public String[] inputParticipateInUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine().split(",");
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public String[] inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine().split(",");
    }

    public String inputShowUserResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        sc = new Scanner(System.in);
        return sc.nextLine();
    }

}

package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    private InputView(){}

    public static String inputParticipantsNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static int inputTheNumberOfLadders() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}

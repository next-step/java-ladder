package ladder.UI;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputParticipants() {
        View.newLine();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        return sc.nextLine();
    }

    public static int inputLadderHeight() {
        View.newLine();
        System.out.println("사다리 높이를 입력 해주세요.");
        return sc.nextInt();
    }
}

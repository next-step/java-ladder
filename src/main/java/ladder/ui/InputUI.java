package ladder.ui;

import java.util.Scanner;

public class InputUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputnameOfParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");

        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇개 인가요?");

        return scanner.nextInt();
    }
}

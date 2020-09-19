package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participantsNames = scanner.next();

        return participantsNames;
    }

    public static int inputLadderDepth() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int participantsNames = scanner.nextInt();

        return participantsNames;
    }
}

package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    public static String[] inputName(Scanner scanner) {
        boolean flag = true;
        String[] participants = null;
        while (flag) {
            try {
                participants = makeParticipants(scanner);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return participants;
    }

    public static int makeDepth(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int depth = Integer.valueOf(scanner.nextLine());

        return depth;
    }

    private static String[] makeParticipants(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] names = scanner.nextLine().split(",");

        return names;
    }
}

package nextstep.ladder.view;

import nextstep.ladder.LadderInput;
import nextstep.ladder.Participants;

import java.util.Scanner;

public class InputView {
    public static LadderInput showInputView(Scanner scanner) {

        boolean flag = true;
        Participants participants = null;
        while (flag) {
            try {
                participants = makeParticipants(scanner);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        int depth = makeDepth(scanner);

        return new LadderInput(participants, depth);
    }

    private static int makeDepth(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int depth = Integer.valueOf(scanner.nextLine());

        return depth;
    }

    private static Participants makeParticipants(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String[] names = scanner.nextLine().split(",");
        Participants participants = Participants.of(names);

        return participants;
    }
}

package ladder.view;

import ladder.domain.Attendees;
import ladder.domain.LadderOption;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static Attendees inputAttendees() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return Attendees.create(scanner.next());
    }

    public static LadderOption inputLadderOption() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        return LadderOption.create(scanner.nextInt());
    }
}

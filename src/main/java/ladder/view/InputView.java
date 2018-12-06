package ladder.view;

import ladder.domain.Attendee;
import ladder.domain.Attendees;
import ladder.domain.Gifts;
import ladder.domain.LadderOption;
import ladder.strategy.Difficulty;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static Attendees inputAttendees() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return Attendees.create(scanner.next());
    }

    public static LadderOption inputLadderOption() {
        System.out.println("\n실행할 사다리의 난이도는?");
        Scanner scanner = new Scanner(System.in);
        String difficulty = scanner.nextLine();
        return LadderOption.create(difficulty);
    }

    public static Gifts inputGifts() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return Gifts.create(scanner.next());
    }

    public static Attendee inputAttendee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n결과를 보고 싶은 사람은?");
        return Attendee.create(scanner.next());
    }
}

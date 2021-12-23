package ladder.view;

import ladder.domain.Participants;
import ladder.domain.Prizes;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Participants getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)초 구분하세요)");
        String names = scanner.next();
        return new Participants(names);
    }

    public Prizes getPrizes(Participants participants) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String names = scanner.next();
        return new Prizes(names, participants.size());
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String getParticipant() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}

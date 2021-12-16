package ladder.view;

import ladder.domain.Participants;

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

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}

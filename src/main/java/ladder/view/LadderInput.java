package ladder.view;

import ladder.InformationForGame;

import java.util.Scanner;

public class LadderInput {

    private final Scanner scanner = new Scanner(System.in);

    public InformationForGame participant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participants = scanner.nextLine();
        return new InformationForGame(participants,ladderCount());
    }

    private String ladderCount() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }
}

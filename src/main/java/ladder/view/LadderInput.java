package ladder.view;

import ladder.Ladder;

import java.util.Scanner;

public class LadderInput {

    private final static Scanner SCANNER = new Scanner(System.in);

    public String participant() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return  SCANNER.nextLine();
    }

    public String ladderCount() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextLine();
    }
}

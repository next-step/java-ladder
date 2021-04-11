package nextstep.ladder.view;

import nextstep.ladder.utils.PreCondition;

import java.util.Scanner;

public class InputView {
    private static final String PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String players() {
        System.out.println(PLAYERS);
        String players = scanner.nextLine().trim();
        PreCondition.checkNullOrEmpty(players);
        return players;
    }
}

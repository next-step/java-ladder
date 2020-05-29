package nextstep.ladder.ui;

import nextstep.ladder.domain.PlayerNames;

import java.util.Scanner;

public class InputView {
    private PlayerNames playerNames;
    private int maxLadderHeight;

    public InputView(String playerList, int maxLadderHeight) {
        this.playerNames = PlayerNames.create(playerList);
        this.maxLadderHeight = maxLadderHeight;
    }

    public static InputView createByUserInput(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerList = scanner.nextLine();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxLadderHeight = scanner.nextInt();

        return new InputView(playerList, maxLadderHeight);
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }
}

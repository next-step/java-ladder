package nextstep.ladder.ui;

import nextstep.ladder.domain.PlayerNames;

import java.util.Scanner;

public class InputView {
    private static final int MIN_MAXLADDERHEIGHT = 1;
    private static final String INPUT_PLAYERS_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_COMMENT = "최대 사다리 높이는 몇 개인가요?";

    private PlayerNames playerNames;
    private int maxLadderHeight;

    public InputView(String playerList, int maxLadderHeight) {
        validateLadderHeight(maxLadderHeight);
        this.playerNames = PlayerNames.create(playerList);
        this.maxLadderHeight = maxLadderHeight;
    }

    public static InputView createByUserInput(Scanner scanner) {
        return new InputView(getUserInputPlayers(scanner), getUserInputMaxLadderHeight(scanner));
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }

    public int getPlayerSize() {
        return this.playerNames.size();
    }

    private static int getUserInputMaxLadderHeight(Scanner scanner) {
        System.out.println(INPUT_LADDER_HEIGHT_COMMENT);
        return scanner.nextInt();
    }

    private static String getUserInputPlayers(Scanner scanner) {
        System.out.println(INPUT_PLAYERS_COMMENT);
        return scanner.nextLine();
    }

    private void validateLadderHeight(int maxLadderHeight) {
        if (maxLadderHeight < MIN_MAXLADDERHEIGHT) {
            throw new IllegalArgumentException("Max Ladder Height must bigger than 0");
        }
    }
}

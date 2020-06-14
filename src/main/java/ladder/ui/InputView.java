package ladder.ui;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.player.LadderPlayers;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLITTER = ",";

    public static LadderPlayers inputGamerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = scanner.nextLine();
        return LadderPlayers.participate(playerNames.split(SPLITTER));
    }

    public static LadderHeight inputLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return LadderHeight.inputHeight(height);

    }
}

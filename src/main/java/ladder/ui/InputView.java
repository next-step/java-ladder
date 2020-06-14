package ladder.ui;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayer;
import ladder.domain.game.LadderRewards;
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

    public static LadderRewards inputGameResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String rewords = scanner.nextLine();
        return LadderRewards.inputRewards(rewords.split(SPLITTER));
    }

    public static LadderPlayer inputTargetPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        String playerName = scanner.nextLine();
        return LadderPlayer.create(playerName);
    }

    public static LadderHeight inputLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        return LadderHeight.inputHeight(height);

    }
}

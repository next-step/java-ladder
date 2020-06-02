package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PointAddStrategy;
import nextstep.ladder.domain.RandomPointAddStrategy;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner playerInputScanner = new Scanner(System.in);
        PlayerInputView playerInputView = PlayerInputView.createByUserInput(playerInputScanner);

        Scanner maxLadderHeightInputScanner = new Scanner(System.in);
        LadderHeightInputView ladderHeightInputView = LadderHeightInputView
                .createByUserInput(maxLadderHeightInputScanner);

        PointAddStrategy pointAddStrategy = new RandomPointAddStrategy();
        Ladder ladder = Ladder.create(ladderHeightInputView.getMaxLadderHeight(),
                playerInputView.getPlayerSize(), pointAddStrategy);
        OutputView outputView = new OutputView(playerInputView.getPlayers(), ladder);

        System.out.println(outputView.parsePlayerNames());
        System.out.println(outputView.parseLadder());
    }
}

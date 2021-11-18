package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.dto.GameInformation;
import nextstep.step2.dto.LadderInformation;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.RandomBooleanGenerateStrategy;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String namesString = inputView.inputNames();
        String heightString = inputView.inputHeight();

        Ladder ladder = getLadder(namesString, heightString);

        LadderGame game = getLadderGame(namesString, ladder);

        outputView.renderLadder(game);
    }

    private static LadderGame getLadderGame(String namesString, Ladder ladder) {
        GameInformation gameInformation = GameInformation.createWithString(namesString);
        LadderGame game = LadderGame.createWithInfoAndLadder(gameInformation, ladder);
        return game;
    }

    private static Ladder getLadder(String namesString, String heightString) {
        LadderInformation ladderInformation = LadderInformation.createWithString(namesString, heightString);
        BooleanGenerateStrategy strategy = new RandomBooleanGenerateStrategy();
        Ladder ladder = Ladder.createWithLadderInformation(ladderInformation, strategy);
        return ladder;
    }
}

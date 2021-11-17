package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
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
        BooleanGenerateStrategy strategy = new RandomBooleanGenerateStrategy();

        LadderInformation info = LadderInformation.create(namesString, heightString);
        LadderGame game = LadderGame.createWithLadderInformation(info,strategy);

        outputView.renderLadder(game);
    }
}

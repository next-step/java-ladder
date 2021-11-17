package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.dto.LadderInformation;
import nextstep.step2.view.InputView;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.RandomBooleanGenerateStrategy;

public class main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesString = inputView.inputNames();
        String heightString = inputView.inputHeight();
        BooleanGenerateStrategy strategy = new RandomBooleanGenerateStrategy();

        LadderInformation info = LadderInformation.create(namesString, strategy, heightString);
        Ladder.createWithLadderInformation(info);
    }
}

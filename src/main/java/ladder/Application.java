package ladder;

import ladder.domain.*;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.RandomLadder;
import ladder.domain.ladder.RandomLadderFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final LadderFactory LADDER_FACTORY = new RandomLadderFactory();

    public static void main(String[] args) {
        Names names = InputView.inputNames();
        int height = InputView.inputHeight();
        List<String> prizes = InputView.inputPrizes(names.names().size());

        RandomLadder randomLadder = LADDER_FACTORY.createLadder(names.names().size() - 1, height);
        Map<Name, String> result = LadderGame.playing(names, prizes, randomLadder);

        ResultView.printResult(names, randomLadder, prizes);

        String resultTarget = InputView.inputPersonName();
        ResultView.printPersonPrize(resultTarget, result);
    }





}

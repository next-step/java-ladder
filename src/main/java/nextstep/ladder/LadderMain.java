package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String participatorsName = inputView.inputParticipators();
        String ladderPrice = inputView.inputLadderPrice();
        int ladderHeight = inputView.inputLadderHeight();

        Participators participators = Participators.from(makeStringList(participatorsName));
        Ladder ladder = Ladder.makeLadder(participators.participatorCount(), ladderHeight);
        LadderResult ladderResult = new LadderResult(makeStringList(ladderPrice));

        participators.playLadder(ladder);

        outputView.printLadderStatus(participators, ladder, ladderResult);

        String name = inputView.inputResultName();

        GameResult gameResult = new GameResult(participators, ladderResult);
        String result = gameResult.gameResult(name);
        outputView.printResult(result);
    }

    private static List<String> makeStringList(String participators) {
        return Arrays.stream(participators.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participators;
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
        int ladderHeight = inputView.inputLadderHeight();

        Participators participators = Participators.from(makeNameList(participatorsName));
        Ladder ladder = Ladder.makeLadder(participators.participatorCount(), ladderHeight);

        outputView.printResult(participators, ladder);
    }

    private static List<String> makeNameList(String participators) {
        return Arrays.stream(participators.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

package nextstep.ladder;

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



        outputView.printResult();
    }

    private static List<String> makeNameList(String participators) {
        return Arrays.stream(participators.split(","))
                .collect(Collectors.toList());
    }
}

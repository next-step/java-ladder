package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LineApplication {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        JoinMembers joinMembers = new JoinMembers(inputNames.stream().map(Member::new).collect(Collectors.toList()));

        int inputHeight = InputView.inputHeight();
        Ladder ladder = new Ladder(inputHeight, joinMembers.getNumberOfMembers());

        OutputView.outputLadder(joinMembers, ladder);
    }
}

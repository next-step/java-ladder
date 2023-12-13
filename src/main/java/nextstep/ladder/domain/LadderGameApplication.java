package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> inputNames = InputView.inputNames();
        List<Member> members = inputNames.stream()
                .map(Member::new)
                .collect(Collectors.toList());
        int inputHeight = InputView.inputHeight();
        // TODO 수정 예정
        Ladder ladder = new Ladder(inputHeight, inputNames.size());

        OutputView.outputLadder(members, ladder);
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.LinesFactory;
import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.RunResult;
import nextstep.ladder.domain.RunResults;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Objects;

public class LadderMain {
    private static final String FINISH_KEYWORD = "all";

    public static void main(String[] args) {
        Members members = InputView.inputMemberNames();
        RunResults runResults = InputView.inputRunResults();
        MaxHeightOfLadder maxHeightOfLadder = InputView.inputMaxHeightOfLadder();

        Lines lines = LinesFactory.create(members, maxHeightOfLadder);

        OutputView.outputLadder(members, lines, runResults);

        members.movePositions(lines);

        String name;
        while (!Objects.equals(name = InputView.inputName(), FINISH_KEYWORD)) {
            RunResult runResult = runResults.findRunResult(name, members);
            OutputView.output(runResult);
        }

        OutputView.outputRunResults(runResults, members);
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.line.LinesFactory;
import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.domain.runresult.RunResult;
import nextstep.ladder.domain.runresult.RunResults;
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

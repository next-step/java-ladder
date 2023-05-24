package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderHeight;
import nextstep.ladder.domain.user.ExecuteResults;
import nextstep.ladder.domain.user.Participants;
import nextstep.ladder.domain.user.Result;
import nextstep.ladder.domain.user.UserName;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.showUserNamesConsole());
        ExecuteResults executeResults = ExecuteResults.of(InputView.showExecuteResultsConsole());
        LadderHeight ladderHeight = LadderHeight.from(InputView.showLadderHeightConsole());

        Ladder ladder = Ladder.create(ladderHeight.getHeight(), participants.count());

        ResultView.drawInputResult(participants, executeResults, ladder);
        execute(participants, executeResults, ladder);
    }

    private static void execute(Participants participants, ExecuteResults executeResults, Ladder ladder) {
        executeResults.execute(participants, ladder);

        RepeatStatus repeatStatus = new RepeatStatus(true);
        while (repeatStatus.repeatable()) {
            drawUserResult(executeResults, repeatStatus);
        }
    }

    private static void drawUserResult(ExecuteResults executeResults, RepeatStatus repeatStatus) {
        UserName inputUserName = UserName.add(InputView.showUserResultConsole());
        if (inputUserName.isAll()) {
            repeatStatus.stop();
            ResultView.drawUserResult(executeResults.toAllResults());
            return;
        }
        Result result = executeResults.toUserResult(inputUserName);
        ResultView.drawUserResult(result.getValue());
    }

}

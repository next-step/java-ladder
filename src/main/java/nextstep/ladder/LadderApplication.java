package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderHeight;
import nextstep.ladder.domain.ladder.Lines;
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

        Ladder ladder = new Ladder(Lines.create(ladderHeight.getHeight(), participants.count()));

        ResultView.drawResultMessage();
        ResultView.drawParticipants(participants);
        ResultView.drawLadder(ladder);
        ResultView.drawExecuteResults(executeResults);

        executeResults.execute(participants, ladder);

        RepeatStatus repeatStatus = new RepeatStatus(true);
        while (repeatStatus.repeatable()) {
            UserName inputUserName = UserName.add(InputView.showUserResultConsole());
            if (inputUserName.isAll()) {
                repeatStatus.stop();
                ResultView.drawUserResult(executeResults.toArray());
                break;
            }
            Result result = executeResults.getResult(inputUserName);
            ResultView.drawUserResult(result.getValue());
        }
    }

    static class RepeatStatus {

        private boolean repeat;

        public RepeatStatus(boolean repeat) {
            this.repeat = repeat;
        }

        public boolean repeatable() {
            return repeat;
        }

        public void stop() {
            repeat = false;
        }

    }

}

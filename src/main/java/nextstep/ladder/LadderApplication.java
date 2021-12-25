package nextstep.ladder;

import nextstep.ladder.controller.CreateLadderRequest;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.RetrieveResultRequest;
import nextstep.ladder.controller.UsersLadderResults;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController controller = new LadderController();
        Users users = Users.from(InputView.readUserNames());
        LadderResults ladderResults = LadderResults.from(InputView.readLadderResults());
        Ladder ladder = controller.createLadder(CreateLadderRequest.of(users.size(), InputView.readHeightOfLadder()));
        OutputView.printLadderResult(users, ladder, ladderResults);
        OutputView.printExecutionResultForUsers(controller.retrieveUserResults(RetrieveResultRequest.of(ladder, UsersLadderResults.of(users, ladderResults))), InputView.readCommandForResultOfTargetUser());
    }
}

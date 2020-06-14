package nextstep.ladder;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.game.Results;
import nextstep.ladder.domain.ladder.DirectionRandomPredicate;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.utils.UserConverter;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = UserConverter.convertToList(InputView.inputUserName());
        int maxHeight = InputView.inputMaximumLadderHeight();

        Ladder ladder = new Ladder(Height.from(maxHeight), users.size(), new DirectionRandomPredicate());
        ResultView.printLadder(users, ladder);

        List<String> results = InputView.inputResults();
        LadderGame ladderGame = new LadderGame(ladder, new Results(results));

        boolean isPlay = true;

        while(isPlay) {
            String input = InputView.inputUserForResult();
            isPlay = input.equalsIgnoreCase(InputView.STOP) ? false : true;
            List<User> userForResult = UserConverter.convertToListFromInput(input, users);
            LadderGameResult ladderGameResult = ladderGame.play(userForResult);
            ResultView.printResult(ladderGameResult);
        }
    }
}

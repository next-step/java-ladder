package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class App {
    public static void main(String[] args) {
        String usersRaw = InputView.inputUsers();
        String resultsRaw = InputView.inputResults();
        int height = InputView.inputHeight();

        Ladder ladder = Ladder.random(usersRaw, resultsRaw, height);

        OutputView.drawLadderGame(ladder);

        String username = InputView.inputUsernameToViewResult();
        OutputView.printResult(username, ladder);
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class App {
    public static void main(String[] args) {
        String usersRaw = InputView.inputUsers();
        String resultsRaw = InputView.inputResults();
        Users users = Users.ofByRaw(usersRaw);
        Result result = Result.ofByRaw(resultsRaw);

        int height = InputView.inputHeight();

        Ladder ladder = Ladder.random(users.countOfUsers(), height);

        OutputView.drawLadderGame(ladder, users, result);

        String username = InputView.inputUsernameToViewResult();
        int order = users.getOrderByUsername(username);
        int lastCol = ladder.getResultByUserOrder(order);
        String resultByOrder = result.getResultByOrder(lastCol);
        System.out.println(resultByOrder);


    }
}

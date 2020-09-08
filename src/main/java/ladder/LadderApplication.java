package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    private static final String ALL_USER_QUERY_STRING = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> userNames = inputView.getUserNames();
        List<String> prizeNames = inputView.getPrizeNames();
        int width = inputView.getWidth();

        LadderGame ladderGame = LadderGame.of(userNames, width, new RandomGenerateStrategy());
        Prizes prizes = Prizes.of(prizeNames);

        resultView.printLadderResultPhrase();
        resultView.printLadderElements(ladderGame.getUsersName());
        resultView.printLadder(ladderGame.getLines());
        resultView.printLadderElements(prizes.getPrizeNames());

        while (true) {
            String resultUserName = inputView.getResultUserName();

            if (ALL_USER_QUERY_STRING.equals(resultUserName)) {
                userNames.stream()
                        .map(User::new)
                        .forEach(user -> {
                            int point = ladderGame.play(user);
                            resultView.printResult(user.getName(), prizes.getPrizeByIndex(point).getPrize());
                        });
                break;
            }
            int point = ladderGame.play(new User(resultUserName));
            resultView.printResult(resultUserName, prizes.getPrizeByIndex(point).getPrize());
        }

    }

}

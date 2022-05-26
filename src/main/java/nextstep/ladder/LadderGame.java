package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.util.RandomConnectStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    private static final String UNEXPECTED_ERROR_MESSAGE = "[ERROR] 예상치못한 에러가 발생했습니다. 게임을 재시작합니다.";
    private static final String LADDER_GAME_ERROR_MESSAGE = "\n[INFO] 게임을 재시작합니다.";

    public void start() {
        try {
            String names = InputView.inputPeopleName();
            String resultNames = InputView.inputResults();
            String ladderHeight = InputView.inputLadderHeight();

            People people = People.from(names);
            Ladder ladder = Ladder.from(Integer.parseInt(ladderHeight), people, new RandomConnectStrategy());
            Results results = ladder.results(resultNames);

            ResultView.printResults(people, ladder, results);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + LADDER_GAME_ERROR_MESSAGE);
            start();
        } catch (Exception e) {
            System.out.println(UNEXPECTED_ERROR_MESSAGE);
            start();
        }
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}

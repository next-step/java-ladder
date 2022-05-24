package nextstep.ladder;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.person.Person;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.util.RandomConnectStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    private static final String UNEXPECTED_ERROR_MESSAGE = "[ERROR] 예상치못한 에러가 발생했습니다. 게임을 재시작합니다.";
    private static final String LADDER_GAME_ERROR_MESSAGE = "\n[INFO] 게임을 재시작합니다.";
    private static final String ALL = "all";

    public void start() {
        try {
            String names = InputView.inputPeopleName();
            String resultNames = InputView.inputResults();
            String ladderHeight = InputView.inputLadderHeight();

            People people = People.from(names);
            Ladder ladder = Ladder.from(Integer.parseInt(ladderHeight), people, new RandomConnectStrategy());
            Results results = ladder.results(resultNames);

            ResultView.printResults(people, ladder, results);
            findPersonResult(people, ladder, results);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + LADDER_GAME_ERROR_MESSAGE);
            start();
        } catch (Exception e) {
            System.out.println(UNEXPECTED_ERROR_MESSAGE);
            start();
        }
    }

    public void findPersonResult(People people, Ladder ladder, Results results) {
        while (true) {
            if (matchPersonAndResult(people, ladder, results)) {
                break;
            }
        }
    }

    private boolean matchPersonAndResult(People people, Ladder ladder, Results results) {
        String findName = InputView.InputFindPersonName();
        if (findName.equals(ALL)) {
            ResultView.printPersonAndResult(people.people(), ladder.results(people, results));
            return true;
        }

        try {
            Person person = people.person(findName);
            Position resultPosition = ladder.move(person);
            ResultView.printMatchResult(results.result(resultPosition));
        } catch (Exception e) {
            findPersonResult(people, ladder, results);
        }
        return false;
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}

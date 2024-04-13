package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        List<Person> people = InputView.getPeople();
        List<String> results = InputView.getResults();
        if (people.size() != results.size()) {
            throw new IllegalArgumentException("참가자의 수와 결과의 수가 일치하지 않습니다.");
        }
        int countOfPerson = people.size();
        int height = InputView.getHeight();
        InputView.getNextLine();

        LadderGame ladderGame = new LadderGame(height, countOfPerson);
        ladderGame.getLines()
                .forEach(line -> people.forEach(line::crossLadder));

        OutputView.printLadder(people, ladderGame, results);
        String personName = InputView.getPersonName();
        OutputView.printResult(personName, people, results);
    }

}

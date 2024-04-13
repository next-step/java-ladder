package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        List<Person> people = InputView.getPersonNames();
        List<String> results = InputView.getResults();
        int countOfPerson = people.size();
        int height = InputView.getHeight();

        OutputView.printLadder(people, new LadderGame(height, countOfPerson), results);

        //todo: 실행결과 로직 (여기부터)
    }

}

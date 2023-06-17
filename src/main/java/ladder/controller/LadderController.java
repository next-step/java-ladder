package ladder.controller;

import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Prize;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        Persons persons;
        Prize prize;
        Ladder ladder;

        String namesOfPersons = InputView.promptNamesOfPersons();
        String prizes = InputView.promptPrizes();
        int heightOfRadder = InputView.promptHeightOfRadder();

        persons = Persons.of(namesOfPersons);
        prize = Prize.of(prizes, persons.getCount());

        ladder = Ladder.of(persons.getCount(), heightOfRadder);

        ResultView resultView = new ResultView();
        resultView.viewLadderResult(persons, ladder, prize);


        while (true) {
            String name = InputView.promptNameForResult();

            if (name == null || name.trim().isEmpty()) {
                break;
            }

            List<Person> listOfpersons = persons.getList(name);

            resultView.viewResultTitle();
            listOfpersons.stream()
                    .forEach(x -> resultView.viewPersonResult(x, prize.getPrize(ladder.getLastPosition(x.getPosition()))));
        }
    }
}

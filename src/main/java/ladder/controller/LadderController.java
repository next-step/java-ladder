package ladder.controller;

import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Prize;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private static Persons persons;
    private static Prize prize;
    private static Ladder ladder;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesOfPersons = inputView.promptNamesOfPersons();
        String prizes = inputView.promptPrizes();
        int heightOfRadder = inputView.promptHeightOfRadder();

        persons = Persons.of(namesOfPersons);
        prize = Prize.of(prizes, persons.getCount());

        ladder = Ladder.of(persons.getCount(), heightOfRadder);

        ResultView resultView = new ResultView();
        resultView.viewLadderResult(persons, ladder, prize);


        while (true) {
            String name = inputView.promptNameForResult();

            if (name == null || name.trim().isEmpty()) {
                break;
            }

            moveAndViewResult(name, resultView);
        }
    }

    private static void moveAndViewResult(String name, ResultView resultView) {
        List<Person> listOfpersons = persons.getList(name);

        resultView.viewResultTitle();
        listOfpersons.stream()
                .forEach(x -> resultView.viewPersonResult(x, prize.getPrize(ladder.getLastPosition(x.getPosition()))));
    }
}

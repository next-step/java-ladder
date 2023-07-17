package ladder.controller;

import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Prize;
import ladder.domain.JerryLadder;
import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.factory.LadderFactoryBean;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        Persons persons = Persons.of(InputView.promptNamesOfPersons());
        Prize prize = new Prize(InputView.promptPrizes(), persons.getCount());

        LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory();
        Ladder ladder = ladderCreator.create(persons.getCount(), InputView.promptHeightOfRadder());

        ResultView.viewLadderResult(persons, ladder, prize);

        String nameToCheck;
        while (true) {
            try {
                nameToCheck = InputView.promptNameForResult();
            } catch (IllegalArgumentException e) {
                return;
            }

            List<Person> listOfpersons = persons.getList(nameToCheck);

            ResultView.viewResultTitle();
            listOfpersons.stream()
                    .forEach(x -> ResultView.viewPersonResult(x, prize.getPrize(ladder.getLastPosition(x.getPosition()))));
        }
    }
}

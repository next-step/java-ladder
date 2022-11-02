package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.factory.RandomLadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        Person person = new Person(InputView.inputPerson());
        int height = InputView.inputLadderHeight();

        LadderFactory ladderFactory = new RandomLadderFactory();
        Ladder ladder = ladderFactory.creatLadder(height, person.countPerson());

        OutputView.outputResult(person, ladder);
    }
}

package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.printLadder;

public class Main {
    public static void main(String[] args) {
        People people= People.from(getPersonNames());
        Ladder ladder = Ladder.from(getLadderHeight());
        ladder.generateLadder(people, getConditional());

        LadderGame ladderGame = LadderGame.from(people, ladder);
        Result result = Result.from(getResultReward());
        printLadder(ladderGame, result);

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculatePersonPosition(ladder);

        do{
            String personName = getSelectResultPerson();
            ResultView.printReward(result, personPosition, personName);
        } while (true);
    }

    private static Conditional getConditional() {
        return people -> Line.from(people.peopleCount());
    }
}

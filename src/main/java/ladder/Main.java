package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import java.util.Map;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.printLadderGame;

public class Main {
    public static void main(String[] args) {
        People people= People.from(getPersonNames());
        Ladder ladder = Ladder.from(getLadderHeight(), people.size());
        ladder.generateLadder(getConditional());

        LadderGame ladderGame = LadderGame.from(people, ladder);
        Reward reward = Reward.from(getResultReward());
        printLadderGame(ladderGame, reward);

        PersonPosition personPosition = PersonPosition.from(people);
        personPosition.calculateFinalPosition(ladder);

        do{
            ResultView.printReward();
            String result = getResultPerson();
            if ("all".equals(result)) {
                ResultView.printAllReward(reward, personPosition);
            } else {
                ResultView.printPersonReward(reward, personPosition, result);
            }
        } while (true);
    }

    private static Conditional getConditional() {
        return width -> LadderLine.from(width.size());
    }


}

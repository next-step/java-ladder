package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import static ladder.view.InputView.*;

public class Main {
    public static void main(String[] args) {
        People people = People.from(getPersonNames());
        LadderSize ladderSize = LadderSize.from(getLadderHeight(), people.size());
        Ladder ladder = Ladder.from(ladderSize, getConditional());

        Reward reward = Reward.from(getResultReward());
        ResultView.printPeopleList(people);
        ResultView.printLadder(ladder);
        ResultView.printRewardList(reward);

        do {
            String input = getResultPerson();
            ResultView.printReward();
            if ("all".equals(input)) {
                PersonPosition personPosition = PersonPosition.from(people, ladder);
                ResultView.printAllReward(reward, personPosition);
            } else {
                Position position = people.findPositionBy(input);
                ladder.progressGame(position);
                ResultView.printPersonReward(reward, position);
            }
        } while (true);
    }

    private static Conditional getConditional() {
        return width -> LadderLine.from(width);
    }

}

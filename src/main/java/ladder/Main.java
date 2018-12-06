package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import static ladder.view.InputView.*;

public class Main {
    public static void main(String[] args) {
        People people = People.from(getPersonNames());
        LadderSize ladderSize = LadderSize.from(getLadderHeight(), people.size());
        Ladder ladder = Ladder.from(ladderSize);

        Reward reward = Reward.from(getResultReward());
        ResultView.printPeopleList(people);
        ResultView.printLadder(ladder);
        ResultView.printRewardList(reward);

        getDifficulty();

        do {
            String input = getResultPerson();
            ResultView.printReward();
            if ("all".equals(input)) {
                PersonPosition personPosition = PersonPosition.from(people, ladder);
                ResultView.printAllReward(reward, personPosition);
            } else {
                int index = people.findPositionBy(input);
                int resultPosition = ladder.progressGame(index);
                ResultView.printPersonReward(reward, resultPosition);
            }
        } while (true);
    }

}

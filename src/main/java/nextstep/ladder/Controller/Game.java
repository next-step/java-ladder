package nextstep.ladder.Controller;

import nextstep.ladder.Model.*;
import nextstep.ladder.View.LadderInput;
import nextstep.ladder.View.LadderOutput;

public class Game {

    public void play() {
        LadderGenerator ladderGenerator = new LadderGenerator();
        People people = LadderInput.askAttendMembers();
        Rewards rewards = LadderInput.askRewards();
        Height height = LadderInput.askMaxHeight();
        Ladder ladder = ladderGenerator.generateLadder(people.size(), height);
        people.offerReward(ladder, rewards);
        LadderOutput.printLadderResultTitle();
        LadderOutput.printLadderResultPeoPle(people);
        LadderOutput.printLadderResultLadder(ladder);
        LadderOutput.printLadderResultRewards(rewards);
        while (true) {
            String resultName = LadderInput.askResultName();
            LadderOutput.printExecuteResult(resultName, people);
            if ("stop".equals(resultName)) {
                break;
            }
        }
    }
}

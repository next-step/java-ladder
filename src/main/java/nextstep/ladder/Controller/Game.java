package nextstep.ladder.Controller;

import nextstep.ladder.Model.Height;
import nextstep.ladder.Model.Ladder;
import nextstep.ladder.Model.LadderGenerator;
import nextstep.ladder.Model.Names;
import nextstep.ladder.View.LadderInput;
import nextstep.ladder.View.LadderOutput;

public class Game {

    public void play() {
        LadderGenerator ladderGenerator = new LadderGenerator();
        Names names = LadderInput.askAttendMembers();
        Height height = LadderInput.askMaxHeight();
        Ladder ladder = ladderGenerator.generateLadder(names.size(), height);
        LadderOutput.printResult(names, ladder);
    }
}

package ladder;

import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.domain.RandomDrawStrategy;
import ladder.view.LadderInputView;
import ladder.view.LadderResultView;

public class LadderMain {
    public static void main(String[] args) {
        // input start
        Persons persons = Persons.fromText(LadderInputView.personNames());
        int height = LadderInputView.ladderHeight();
        Ladder ladder = new Ladder(persons, height, new RandomDrawStrategy());
        // input end

        // result start
        LadderResultView.printPersonWithLadder(persons, ladder);
        // result end
    }
}

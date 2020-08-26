package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.command.LadderResultCommand;
import ladder.domain.command.LadderResultCommandFactory;
import ladder.domain.element.Persons;
import ladder.domain.element.Prizes;
import ladder.domain.line.RandomDrawStrategy;
import ladder.view.LadderInputView;
import ladder.view.LadderResultView;

public class LadderMain {
    public static void main(String[] args) {
        // input start
        Persons persons = Persons.fromText(LadderInputView.personNames());
        Prizes prizes = Prizes.fromText(LadderInputView.prizes());
        int height = LadderInputView.ladderHeight();
        Ladder ladder = new Ladder(persons, height, new RandomDrawStrategy());
        // input end

        LadderGame ladderGame = new LadderGame(persons, ladder, prizes);

        // result start
        LadderResultView.printPersonWithLadder(ladderGame);
        while (true) {
            String name = LadderInputView.wantToSeePersonName();
            LadderResultCommand ladderResultCommand = LadderResultCommandFactory.ladderResultCommand(name);
            LadderResultView.printLadderGameResult(ladderResultCommand.showResult(ladderGame, name));
        }
        // result end
    }
}

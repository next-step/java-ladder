package ladder.controller;

import ladder.domain.game.Ladder;
import ladder.domain.game.Names;
import ladder.strategy.ConnectionStrategy;
import ladder.strategy.RandomConnectionStrategy;
import ladder.view.InputView;
import ladder.domain.game.LadderResult;
import ladder.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-12-07.
 */
public class Controller {

    public final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Names participants = Names.from(InputView.askParticipantList());

        Names goals = Names.from(InputView.askGoal());

        int height = InputView.askLadderHeight();

        ConnectionStrategy connectionStrategy = new RandomConnectionStrategy();
        Ladder ladder = Ladder.of(participants.getSize(), connectionStrategy, height);

        ResultView.printLadder(participants, ladder, goals);

        LadderResult ladderResult = LadderResult.of(participants, ladder.moveAll(goals));

        String inputName;

        do {
            inputName = InputView.askResultPerson();
            ResultView.printGoals(ladderResult, inputName);
        } while (!inputName.equals(ResultView.RESERVED_WORD_ALL));

    }
}

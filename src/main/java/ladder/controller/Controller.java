package ladder.controller;

import ladder.domain.game.Ladder;
import ladder.domain.game.LadderManager;
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

        LadderManager ladderManager = new LadderManager.Builder()
                .participants(participants)
                .goals(goals)
                .build(connectionStrategy, height);

        ResultView.printLadder(ladderManager);

        String inputName;

        do {
            inputName = InputView.askResultPerson();
            ResultView.printGoals(ladderManager.getLadderResult(), inputName);
        } while (!inputName.equals(ResultView.RESERVED_WORD_ALL));

    }
}

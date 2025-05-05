package nextstep;

import nextstep.domain.Bonuses;
import nextstep.domain.Command;
import nextstep.domain.Ladder;
import nextstep.domain.LadderGame;
import nextstep.domain.LadderResult;
import nextstep.domain.Participants;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class Main {
    public static void main(String[] args) {
        /* I/O 선언 */
        InputView in = new InputView();
        OutputView out = new OutputView();

        Participants participants = in.getName();
        Bonuses bonus = in.getBonus(participants.size());
        int height = in.getHeight();

        Ladder ladder = Ladder.of(participants.size(), height);
        LadderGame game = new LadderGame(bonus, participants, ladder);
        LadderResult result = game.play();

        out.printLadder(participants, ladder, bonus);
        while (true) {
            Command command = Command.of(in.readTarget());
            if (command.isAll()) {
                out.printAllResults(result);
                break;
            }
            out.printPersonalResult(result, command.getValue());
        }
    }
}

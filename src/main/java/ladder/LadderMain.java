package ladder;

import ladder.domain.*;
import ladder.domain.prize.Prizes;
import ladder.domain.prize.PrizesGenerator;
import ladder.domain.user.Users;
import ladder.domain.user.UsersGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        final String usersExpression = InputView.plzEnterUserNames();
        final String prizesExpression = InputView.plzEnterPrizes();
        final int ladderHeight = InputView.plzEnterLadderHeight();

        final Users users = UsersGenerator.generate(usersExpression);
        final Prizes prizes = PrizesGenerator.generate(prizesExpression);

        final LadderGame ladderGame = LadderGame.of(users.size(), ladderHeight);
        
        final List<LadderLine> ladderLines = ladderGame.getLadderLine();
        OutputView.printLadderViewResult(users.getNames(), ladderLines);
    }
}

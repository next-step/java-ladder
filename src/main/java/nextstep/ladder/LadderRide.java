package nextstep.ladder;

import nextstep.ladder.domain.Awards;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.domain.RandomBooleanStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRide {
    private static final String ALL_MEMBERS = "all";

    public static void main(String[] args) {
        Members members = Members.of(InputView.names());
        Prizes prizes = Prizes.of(InputView.prizes());
        Ladder ladder = Ladder.of(members.size(), InputView.height(), new RandomBooleanStrategy());
        Awards awards = new Awards();
        awards.award(members, prizes, ladder);

        ResultView.print(members, ladder, prizes);
        String name = InputView.name();
        while (!ALL_MEMBERS.equals(name)) {
            ResultView.printResult(awards.findWinnerByName(name).prize());
            name = InputView.name();
        }
        ResultView.printResult(awards.winners());
    }
}

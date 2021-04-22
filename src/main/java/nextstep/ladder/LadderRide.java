package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Member;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.domain.RandomBooleanStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRide {

    public static void main(String[] args) {
        Members members = Members.of(InputView.names());
        Prizes prizes = Prizes.of(InputView.prizes());
        Ladder ladder = Ladder.of(members.size(), InputView.height(), new RandomBooleanStrategy());
        ResultView.print(members, ladder, prizes);
        String name = InputView.name();
        while (!"all".equals(name)) {
            ResultView.printResult(prizes.findByIndex(ladder.result(members.findHorizontalNumber(Member.of(name)))));
            name = InputView.name();
        }
    }
}

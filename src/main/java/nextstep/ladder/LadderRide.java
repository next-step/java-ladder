package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRide {

    public static void main(String[] args) {
        Members members = Members.from(InputView.names());
        Ladder ladder = Ladder.of(members.size(), InputView.height());
        ResultView.print(members, ladder);
    }
}

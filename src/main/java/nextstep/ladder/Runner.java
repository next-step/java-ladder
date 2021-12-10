package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.UserCollection;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> people = InputView.inputPeople();
        int height = InputView.inputMaxHeight();
        UserCollection userCollection = UserCollection.of(people);
        Ladder ladder = Ladder.init(people.size(), height);
        OutputView.drawLadderGame(userCollection, ladder);
    }
}

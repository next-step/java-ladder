package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> people = InputView.inputPeople();
        int height = InputView.inputMaxHeight();
        Ladder ladder = Ladder.init(people.size(), height);

    }
}

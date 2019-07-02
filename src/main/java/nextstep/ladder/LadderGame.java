package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LadderGame {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(InputView.askPersonsName().split(","));
        Persons persons = new Persons(names);

        int ladderHeight = InputView.askLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, names.size());

        OutputView.printResult(persons, ladder);
    }
}

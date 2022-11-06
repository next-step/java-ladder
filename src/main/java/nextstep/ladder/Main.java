package nextstep.ladder;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class Main {
    public static final int COUNT_OF_PERSON_MIN = 1;

    public static void main(String[] args) {
        List<Name> names = InputView.queryNames();
        int countOfPerson = names.size();
        if (countOfPerson <= COUNT_OF_PERSON_MIN) {
            throw new IllegalArgumentException("참여 인원이 너무 적습니다.");
        }
        LadderMaxHeight maxHeight = InputView.queryMaxHeight();
        Ladder ladder = new Ladder(countOfPerson, maxHeight);

        ResultView.printNames(names);
        ResultView.printLadder(ladder);
    }
}

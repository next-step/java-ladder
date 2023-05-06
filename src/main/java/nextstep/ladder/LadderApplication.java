package nextstep.ladder;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<PersonName> personNames = InputView.getPersonNames();
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = new Ladder(personNames.size(), ladderHeight);

        OutputView.printLadder(personNames, ladder);
    }
}

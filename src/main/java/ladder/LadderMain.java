package ladder;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        List<String> names = InputView.inputPersonNames();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, names.size(), new HorizontalLineRandomStrategy());
        OutputView.printLadder(names, ladderHeight, ladder);
    }
}

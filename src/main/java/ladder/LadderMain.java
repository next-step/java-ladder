package ladder;

import ladder.domain.Ladder;
import ladder.view.DisplayUtil;
import ladder.util.InputUtil;
import ladder.util.NumberUtil;

public class LadderMain {
    public static void main(String[] args) {
        DisplayUtil.requireNames();
        String names = InputUtil.inputNames();

        DisplayUtil.requireLadderHeight();
        String inputHeight = InputUtil.inputLadderHeight();

        int ladderHeight = NumberUtil.convertStringToInt(inputHeight);

        Ladder ladder = new Ladder(names);
        ladder.generateLadderLine(ladderHeight);

        DisplayUtil.ladderResult(ladder);

    }
}

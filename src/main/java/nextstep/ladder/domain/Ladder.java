package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {
    private final UserInput userInput;
    private final List<Line> ladderLines;

    public Ladder(final UserInput userInput, final BooleanSupplier lineBuilderStrategy) {
        this.userInput = userInput;

        this.ladderLines = initLadderLines(userInput, lineBuilderStrategy);
    }

    private List<Line> initLadderLines(final UserInput userInput, final BooleanSupplier lineBuilderStrategy) {
        List<Line> tempLadderLines = new ArrayList<>();

        final int width = userInput.userNamesSize() - 1;
        final int height = userInput.height();

        for (int i = 0; i < height; i++) {
            tempLadderLines.add(new Line(width, lineBuilderStrategy));
        }

        return tempLadderLines;
    }

    public UserNames userNames() {
        return this.userInput.userNames();
    }

    public UserResults userResults() {
        return this.userInput.userResults();
    }

    public List<Line> ladderLines() {
        return this.ladderLines;
    }

    public LadderResult run() {
        LadderResult ladderResult = new LadderResult();

        for (int userIdx = 0; userIdx < userNames().size(); userIdx++) {
            final int arrivalIdx = move(userIdx);

            ladderResult.add(userNames().get(userIdx), userResults().get(arrivalIdx));
        }

        return ladderResult;
    }

    private int move(int userStartIdx) {
        int userIdx = userStartIdx;

        for (int topToBottomLadderHeight = 0; topToBottomLadderHeight < ladderLines().size(); topToBottomLadderHeight++) {
            final Line line = ladderLines().get(topToBottomLadderHeight);
            userIdx = line.move(userIdx);
        }

        return userIdx;
    }
}

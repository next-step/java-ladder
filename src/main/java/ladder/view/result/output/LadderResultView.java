package ladder.view.result.output;

import ladder.model.result.LadderResults;

public class LadderResultView implements FormattableView {

    private final LadderResults ladderResults;

    public LadderResultView(LadderResults ladderResult) {
        this.ladderResults = ladderResult;
    }

    @Override
    public void render(int formatWidth) {
        ladderResults.forEach(result -> System.out.printf("%" + formatWidth + "s", result));
        System.out.println();
    }
}

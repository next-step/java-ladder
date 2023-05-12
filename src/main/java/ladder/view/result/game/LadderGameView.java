package ladder.view.result.game;

import ladder.model.LadderGame;

public class LadderGameView implements FormattableView {
    private final NamesView namesView;
    private final LadderView ladderView;
    private final LadderResultView ladderResultView;

    public LadderGameView(LadderGame game) {
        this.namesView = new NamesView(game.participants());
        this.ladderView = new LadderView(game.ladder());
        this.ladderResultView = new LadderResultView(game.results());
    }

    @Override
    public void render(int formatWidth) {
        namesView.render(formatWidth);
        ladderView.render(formatWidth);
        ladderResultView.render(formatWidth);
    }
}

package ladder.control.output;


import ladder.model.LadderGame;
import ladder.view.View;
import ladder.view.result.LadderView;
import ladder.view.result.NamesView;

public class LadderGameOutput {
    private final View outputView;
    private final NamesView namesView;
    private final LadderView ladderView;

    public LadderGameOutput(View outputView, LadderGame game) {
        this.outputView = outputView;
        
        this.namesView = new NamesView(game.participants());
        this.ladderView = new LadderView(game.ladder());
    }

    public void print(int formatWidth) {
        outputView.render();
        namesView.render(formatWidth);
        ladderView.render(formatWidth);
    }
}

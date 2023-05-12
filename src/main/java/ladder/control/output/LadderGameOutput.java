package ladder.control.output;


import ladder.model.LadderGame;
import ladder.view.View;
import ladder.view.result.game.LadderGameView;

public class LadderGameOutput {
    private final View info;
    private final LadderGameView output;

    public LadderGameOutput(View outputView, LadderGame game) {
        this.info = outputView;
        this.output = new LadderGameView(game);

    }

    public void print(int formatWidth) {
        info.render();
        output.render(formatWidth);
    }
}

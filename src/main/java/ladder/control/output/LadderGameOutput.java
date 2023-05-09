package ladder.control.output;


import ladder.model.LadderGame;
import ladder.view.View;
import ladder.view.result.LadderGameView;

public class LadderGameOutput {
    private final View outputView;
    private final LadderGameView gameView;

    public LadderGameOutput(View outputView, LadderGame game) {
        this.outputView = outputView;
        this.gameView = new LadderGameView(game);

    }

    public void print(int formatWidth) {
        outputView.render();
        gameView.render(formatWidth);
    }
}

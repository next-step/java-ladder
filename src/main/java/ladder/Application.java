package ladder;

import ladder.control.input.HeightInput;
import ladder.control.input.NamesInput;
import ladder.control.output.LadderGameOutput;
import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Name;
import ladder.model.Names;
import ladder.strategy.RandomStrategy;
import ladder.view.input.HeightView;
import ladder.view.input.NameView;
import ladder.view.result.ResultView;

public class Application {
    public static void main(String[] args) {
        NamesInput namesInput = new NamesInput(new NameView());
        HeightInput heightInput = new HeightInput(new HeightView());

        Names names = namesInput.getValue();

        int width = names.size();
        int height = heightInput.getValue();

        Ladder ladder = Ladder.create(width - 1, height, new RandomStrategy());
        LadderGame game = new LadderGame(names, ladder);

        LadderGameOutput output = new LadderGameOutput(new ResultView(), game);
        output.print(Name.MAX_LENGTH + 1);
    }
}

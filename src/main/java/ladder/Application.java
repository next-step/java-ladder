package ladder;

import ladder.control.input.HeightInput;
import ladder.control.input.NamesInput;
import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Names;
import ladder.strategy.RandomStrategy;
import ladder.view.input.HeightView;
import ladder.view.input.NameView;

public class Application {
    public static void main(String[] args) {
        NamesInput namesInput = new NamesInput(new NameView());
        HeightInput heightInput = new HeightInput(new HeightView());

        Names names = namesInput.getValue();

        int width = names.size();
        int height = heightInput.getValue();

        Ladder ladder = Ladder.create(width, height, new RandomStrategy());
        LadderGame game = new LadderGame(names, ladder);
    }
}

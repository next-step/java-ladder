package ladder;

import ladder.control.HeightInput;
import ladder.control.NamesInput;
import ladder.model.Height;
import ladder.model.Names;
import ladder.view.HeightView;
import ladder.view.NameView;

public class Application {
    public static void main(String[] args) {
        NamesInput namesInput = new NamesInput(new NameView());
        HeightInput heightInput = new HeightInput(new HeightView());

        Names names = namesInput.getValue();
        Height height = heightInput.getValue();

    }
}

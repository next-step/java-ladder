package ladder;

import ladder.control.input.HeightInput;
import ladder.control.input.multiple.LadderResultsInput;
import ladder.control.input.multiple.MultipleInput;
import ladder.control.input.multiple.NamesInput;
import ladder.control.output.LadderGameOutput;
import ladder.model.LadderGame;
import ladder.model.ladder.Ladder;
import ladder.model.participant.Name;
import ladder.model.participant.Names;
import ladder.model.result.LadderResult;
import ladder.model.result.LadderResults;
import ladder.strategy.RandomStrategy;
import ladder.view.input.HeightView;
import ladder.view.input.LadderResultView;
import ladder.view.input.NameView;
import ladder.view.result.ResultView;

public class Application {
    public static void main(String[] args) {
        MultipleInput<Name> namesInput = new NamesInput(new NameView());
        MultipleInput<LadderResult> ladderResultInput = new LadderResultsInput(new LadderResultView());
        HeightInput heightInput = new HeightInput(new HeightView());

        Names names = new Names(namesInput.getValue());
        LadderResults ladderResults = new LadderResults(ladderResultInput.getValue());

        int width = names.size();
        int height = heightInput.getValue();

        Ladder ladder = Ladder.create(width - 1, height, new RandomStrategy());
        LadderGame game = new LadderGame(names, ladder, ladderResults);

        LadderGameOutput output = new LadderGameOutput(new ResultView(), game);
        output.print(Name.MAX_LENGTH + 1);
    }
}

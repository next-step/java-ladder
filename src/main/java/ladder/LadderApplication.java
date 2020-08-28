package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderArgument;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.Names;
import ladder.view.draw.DrawArgument;
import ladder.view.draw.DrawingExecutor;
import ladder.view.input.InputView;

public class LadderApplication {

	public static void main(String[] args) {
		Names names = Names.of(InputView.inputNames());
		LadderArgument argument = LadderArgument.of(names, InputView.inputLadderHeight());
		Ladder ladder = LadderFactory.create(argument);

		DrawArgument drawArgument = DrawArgument.of(names, ladder);
		DrawingExecutor.drawResult(drawArgument);


	}
}

package ladder;

import static java.util.stream.Collectors.toList;

import java.util.List;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderArgument;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.Name;
import ladder.domain.ladder.Names;
import ladder.domain.playing.Winnings;
import ladder.view.draw.DrawingExecutor;
import ladder.view.draw.LadderDrawingArgument;
import ladder.view.draw.ResultDrawingArgument;
import ladder.view.input.InputView;

public class LadderApplication {

	public static void main(String[] args) {
		Names names = Names.of(InputView.inputNames());
		LadderArgument argument = LadderArgument.of(names, InputView.inputLadderHeight());
		Ladder ladder = LadderFactory.create(argument);
		Winnings winnings = Winnings.of(InputView.inputWinnings(), names.getSize());

		LadderDrawingArgument ladderDrawingArgument = LadderDrawingArgument.of(names, ladder, winnings);
		DrawingExecutor.drawResult(ladderDrawingArgument);

		List<Integer> resultNameIndexes = names.getIndexesOf(Name.of(InputView.inputResult()));
		ResultDrawingArgument resultDrawingArgument =
				ResultDrawingArgument.of(Winnings.of(resultNameIndexes.stream()
																	  .map(i -> winnings.getWinningOf(ladder.play(i)))
																	  .collect(toList())),
										 names);
		DrawingExecutor.drawWinningResult(resultDrawingArgument);
	}
}

package ladder;

import ladder.domain.HorizontalStepList;
import ladder.domain.Ladder;
import ladder.view.out.LadderViewer;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GameController {

	private Ladder ladder;

	public GameController(List<String> playerNames, int height){
		Random random = new Random();
		ladder = IntStream.range(0, height)
				.mapToObj((i) -> new HorizontalStepList(playerNames.size(), random::nextBoolean))
				.collect(Ladder.collector());

	}

	public void displayLadder(LadderViewer view){
		view.render(this.ladder);
	}

}

package ladder;

import ladder.domain.HorizontalStepList;
import ladder.domain.Ladder;
import ladder.view.out.LadderViewer;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameController {

	private Ladder ladder;

	private List<String> playerNames;

	public GameController(List<String> playerNames, int height){
		this.playerNames = playerNames;
		Random random = new Random();
		ladder = IntStream.range(0, height)
				.mapToObj((i) -> new HorizontalStepList(playerNames.size(), random::nextBoolean))
				.collect(Ladder.collector());

	}

	public void displayLadder(LadderViewer view){
		view.render(this.getPlayerNames(), this.ladder);
	}

	private Stream<String> getPlayerNames(){
		return Collections.unmodifiableList(playerNames).stream();
	}

}

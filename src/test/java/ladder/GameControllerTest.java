package ladder;

import ladder.view.out.ConsolePrinter;
import ladder.view.out.LadderViewer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

	@Test
	void name() {
		List<String> players = Arrays.asList("A", "B", "C", "D", "E");
		GameController controller = new GameController(players, 5);
		controller.displayLadder(new LadderViewer(new ConsolePrinter(), 5));
	}
}
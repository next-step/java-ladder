package ladder;

import ladder.view.out.ConsolePrinter;
import ladder.view.out.LadderViewer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

	@Test
	void name() {
		GameController controller = new GameController(Arrays.asList("A", "B", "C"), 5);
		controller.displayLadder(new LadderViewer(new ConsolePrinter()));
	}
}
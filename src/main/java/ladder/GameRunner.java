package ladder;

import ladder.view.in.ConsoleDialog;
import ladder.view.in.InputDialog;
import ladder.view.out.ConsoleRenderer;

import java.util.Random;

public class GameRunner {

	public static void main(String args[]) {
		GameController controller = new GameController(new ConsoleRenderer());

		InputDialog input = new ConsoleDialog();
		Random random = new Random();
		controller.ready(input, random::nextBoolean);
		controller.briefResult(input, new ConsoleRenderer());
	}
}

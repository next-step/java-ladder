package ladder;

import ladder.view.in.ConsoleDialog;
import ladder.view.in.InputDialog;
import ladder.view.out.ConsoleRenderer;
import ladder.view.out.MessageRenderer;

public class GameRunner {
	public static void main(String args[]) {
		InputDialog input = new ConsoleDialog();
		MessageRenderer renderer = new ConsoleRenderer();

		GameController controller = new GameController(input, renderer);
		controller.briefResult(input, renderer);
	}
}

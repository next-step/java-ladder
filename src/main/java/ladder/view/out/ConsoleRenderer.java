package ladder.view.out;

public class ConsoleRenderer implements MessageRenderer {

	@Override
	public void print(String message) {
		System.out.println(message);
	}
}
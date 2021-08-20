package ladder.model;

import java.util.Random;

import ladder.exception.InstanceCreateException;
import ladder.message.ErrorMessage;

public class LineSketch {

	private static final Random random = new Random();

	private LineSketch() {
		throw new InstanceCreateException(ErrorMessage.INSTANCE_CREATE_ERROR_MESSAGE);
	}

	public static boolean drawLine() {
		return random.nextBoolean();
	}

}

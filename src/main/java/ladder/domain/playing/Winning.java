package ladder.domain.playing;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Winning {

	private final String winningName;

	public static Winning of(String winningName) {
		return new Winning(winningName.trim());
	}

	@Override
	public String toString() {
		return this.winningName;
	}
}

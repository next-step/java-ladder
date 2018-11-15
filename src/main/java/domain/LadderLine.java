package domain;

import java.util.function.Supplier;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLine {
	private boolean drawn;

	public LadderLine() {
		this.drawn = false;
	}

	public void draw(LadderLine previousLadderLine, Supplier<Boolean> supplier) {
		this.drawn = supplier.get() && !previousLadderLine.isDrawn();

	}

	public boolean isDrawn() {
		return drawn;
	}
}

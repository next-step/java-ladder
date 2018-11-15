package domain;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLine {
	private boolean drawn;

	public void draw(LadderLine previousLadderLine, LadderLineSupplier supplier) {
		this.drawn = supplier.get() && !previousLadderLine.isDrawn();

	}

	public boolean isDrawn() {
		return drawn;
	}
}

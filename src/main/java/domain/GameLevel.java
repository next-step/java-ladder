package domain;

import domain.supplier.HighLevelLadderLineSupplier;
import domain.supplier.LadderLineSupplier;
import domain.supplier.LowLevelLadderLineSupplier;
import domain.supplier.MiddleLevelLadderLineSupplier;

import java.util.Arrays;

/**
 * Created by hspark on 20/11/2018.
 */
public enum GameLevel {
	LOW("하", new LowLevelLadderLineSupplier(), 5),
	MIDDLE("중", new MiddleLevelLadderLineSupplier(), 10),
	HIGH("상", new HighLevelLadderLineSupplier(), 20);

	private String description;
	private LadderLineSupplier supplier;
	private int ladderHeight;

	GameLevel(String description, LadderLineSupplier supplier, int ladderHeight) {
		this.description = description;
		this.supplier = supplier;
		this.ladderHeight = ladderHeight;
	}

	public static GameLevel findLineSupplierByLevel(String levelStr) {
		return Arrays.stream(GameLevel.values()).filter(gameLevel -> gameLevel.isEqualStr(levelStr))
			.findAny().orElseThrow(IllegalAccessError::new);
	}

	public boolean isEqualStr(String levelStr) {
		return this.description.equalsIgnoreCase(levelStr);
	}

	public LadderLineSupplier getSupplier() {
		return supplier;
	}

	public int getLadderHeight() {
		return ladderHeight;
	}
}

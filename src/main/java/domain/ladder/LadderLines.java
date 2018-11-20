package domain.ladder;

import domain.GameLevel;
import domain.supplier.LadderLineSupplier;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 18/11/2018.
 */
public class LadderLines {
	public static final int MIN_LADDER_HEIGHT = 1;

	private List<LadderLine> ladderLines;

	public LadderLines(int height, int sizeOfGamer, LadderLineSupplier supplier) {
		this.ladderLines = IntStream.range(MIN_LADDER_HEIGHT - 1, height).mapToObj(integer -> new LadderLine(sizeOfGamer, supplier))
			.collect(Collectors.toList());
	}

	public LadderLines(GameLevel gameLevel, int sizeOfGamer) {
		this.ladderLines = IntStream.range(MIN_LADDER_HEIGHT - 1, gameLevel.getLadderHeight()).mapToObj(
			integer -> new LadderLine(sizeOfGamer, gameLevel.getSupplier()))
			.collect(Collectors.toList());
	}

	public boolean isBottomLayer(int layerNumber) {
		return ladderLines.size() == layerNumber;
	}

	public LadderLine getLine(int layerNumber) {
		return ladderLines.get(layerNumber);
	}

	public List<LadderLine> getLadderLines() {
		return Collections.unmodifiableList(ladderLines);
	}
}

package domain.ladder;

import domain.LadderLineSupplier;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 18/11/2018.
 */
public class LadderLayers {
	public static final int MIN_LADDER_HEIGHT = 1;

	private List<LadderLayer> ladderLayers;

	public LadderLayers(int height, int width) {
		this.ladderLayers = IntStream.range(MIN_LADDER_HEIGHT - 1, height).mapToObj(integer -> new LadderLayer(width))
			.collect(Collectors.toList());
	}

	public void drawAllLadders(LadderLineSupplier supplier) {
		ladderLayers.stream().forEach(ladderLayer -> ladderLayer.drawLines(supplier));
	}

	public List<LadderLayer> getLadderLayers() {
		return Collections.unmodifiableList(ladderLayers);
	}

	public boolean isBottomLayer(int layerNumber) {
		return ladderLayers.size() == layerNumber;
	}

	public LadderLayer getLayer(int layerNumber) {
		return ladderLayers.get(layerNumber);
	}
}

package domain;

import com.google.common.base.Preconditions;
import domain.dto.LadderLayerDTO;
import domain.dto.LineDTO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLayer {
	public static final int MIN_LADDER_WIDTH = 0;

	private List<LadderLine> ladderLines;

	public LadderLayer(int width) {
		Preconditions.checkArgument(width >= MIN_LADDER_WIDTH, "너비는 0 이상이어야 합니다.");
		this.ladderLines = IntStream.range(MIN_LADDER_WIDTH, width).mapToObj(i -> new LadderLine(new Point(i), new Point(i + 1)))
			.collect(Collectors.toList());
	}

	public LadderLayerDTO getLadderLineDTO() {
		List<LineDTO> lineDTOS = ladderLines.stream().map(LineDTO::of).collect(Collectors.toList());
		return new LadderLayerDTO(Collections.unmodifiableList(lineDTOS));
	}

	public void drawLines(LadderLineSupplier supplier) {
		BinaryOperator<LadderLine> lineBinaryOperator = ladderLineAccumulator(supplier);
		ladderLines.stream().reduce(new LadderLine(new Point(MIN_LADDER_WIDTH - 1), new Point(MIN_LADDER_WIDTH)), lineBinaryOperator);
	}

	public Optional<LadderLine> getPassableLadderLine(Gamer gamer) {
		return ladderLines.stream().filter(gamer::isPassable).findFirst();
	}

	private BinaryOperator<LadderLine> ladderLineAccumulator(LadderLineSupplier supplier) {
		return (previousLadderLine, ladderLine) -> {
			if (supplier.get() && !previousLadderLine.isDrawn()) {
				ladderLine.draw();
			}
			return ladderLine;
		};
	}
}

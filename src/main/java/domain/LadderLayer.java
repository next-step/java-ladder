package domain;

import com.google.common.base.Preconditions;
import domain.dto.LadderLayerDTO;
import domain.dto.LineDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLayer {
	public static final int MIN_LADDER_WIDTH = 0;

	private List<LadderLine> ladderLines;
	private LadderLineSupplier supplier;

	public LadderLayer(int width, LadderLineSupplier supplier) {
		Preconditions.checkArgument(width >= MIN_LADDER_WIDTH, "너비는 0 이상이어야 합니다.");
		this.ladderLines = Stream.iterate(0, i -> i + 1).limit(width)
			.map(i -> new LadderLine()).collect(Collectors.toList());
		this.supplier = supplier;
	}

	public LadderLayerDTO getLadderLineDTO() {
		List<LineDTO> lineDTOS = ladderLines.stream().map(LineDTO::of).collect(Collectors.toList());
		return new LadderLayerDTO(Collections.unmodifiableList(lineDTOS));
	}

	public void drawLines() {
		ladderLines.stream().reduce(new LadderLine(), this::drawLine);
	}

	private LadderLine drawLine(LadderLine previousLadderLine, LadderLine ladderLine) {
		ladderLine.draw(previousLadderLine, supplier);
		return ladderLine;
	}
}

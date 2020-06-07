package nextstep.ladder.domain.line;

import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.dto.LadderRequestDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lines {
    private final List<Line> lines;

    public Lines(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        this.lines = this.generateLines(ladderRequestDto, bridgeGenerator);
    }

    private List<Line> generateLines(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        List<Line> lines = new ArrayList<>();
        int countOfPerson = ladderRequestDto.getNames().size();
        int height = ladderRequestDto.getHeight();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, bridgeGenerator));
        }
        return Collections.unmodifiableList(lines);
    }

    public Line findLine(int height) {
        try {
            return lines.get(height);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("not found line");
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}

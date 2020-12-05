package ladder.DTO;

import ladder.domain.HorizontalLine;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderDTO {

    private final List<HorizontalLine> layout;

    public LadderDTO(List<HorizontalLine> layout) {
        this.layout = layout;
    }

    public List<List<Boolean>> getLayout() {
        return this.layout.stream()
                .map(HorizontalLine::getLine)
                .collect(toList());
    }
}

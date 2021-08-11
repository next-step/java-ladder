package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.HorizontalLine;

public class PrintLineDto {

    private final List<Boolean> bridges;

    public PrintLineDto(final HorizontalLine horizontalLine) {
        this.bridges = horizontalLine.getBridges();
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}

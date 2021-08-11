package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.HorizontalLine;

public class PrintLineDto {

    private final List<Boolean> exists;

    public PrintLineDto(HorizontalLine horizontalLine) {
        this.exists = horizontalLine.getExists();
    }

    public List<Boolean> getExists() {
        return Collections.unmodifiableList(exists);
    }
}

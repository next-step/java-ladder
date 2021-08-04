package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.Line;

public class PrintLineDto {

    private final List<Boolean> exists;

    public PrintLineDto(Line line) {
        this.exists = line.getExists();
    }

    public List<Boolean> getExists() {
        return Collections.unmodifiableList(exists);
    }
}

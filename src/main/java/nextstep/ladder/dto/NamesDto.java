package nextstep.ladder.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NamesDto {
    List<NameDto> names;

    public NamesDto(List<NameDto> names) {
        this.names = new ArrayList<>(names);
    }

    public List<NameDto> getNames() {
        return Collections.unmodifiableList(names);
    }
}

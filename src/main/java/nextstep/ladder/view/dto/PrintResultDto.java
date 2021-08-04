package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Result;

public class PrintResultDto {

    private final List<String> values;

    public PrintResultDto(final List<Result> values) {
        this.values = values.stream()
            .map(Result::getValue)
            .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }
}

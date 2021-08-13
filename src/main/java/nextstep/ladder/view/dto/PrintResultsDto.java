package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.GameResults;

public class PrintResultsDto {

    private final List<String> results;

    public PrintResultsDto(final GameResults gameResults) {
        this.results = gameResults.getValues().stream()
            .map(Result::getValue)
            .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(results);
    }
}

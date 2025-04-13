package nextstep.ladder.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private List<LadderResult> value;

    public LadderResults(List<String> results) {
        this.value = results.stream().map(LadderResult::new).collect(Collectors.toList());
    }
}

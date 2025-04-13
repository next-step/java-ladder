package nextstep.ladder.domain.edge;

import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {
    private List<LadderPrize> value;

    public LadderPrizes(List<String> results) {
        this.value = results.stream().map(LadderPrize::new).collect(Collectors.toList());
    }

    public int size() {
        return value.size();
    }
}

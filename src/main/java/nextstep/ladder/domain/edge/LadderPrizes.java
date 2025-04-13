package nextstep.ladder.domain.edge;

import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {
    private final List<LadderPrize> value;

    public LadderPrizes(List<LadderPrize> prizes) {
        this.value = prizes;
    }

    public int size() {
        return value.size();
    }

    public List<String> getLadderPrizes() {
        return value.stream().map(LadderPrize::getValue).collect(Collectors.toList());
    }

    public LadderPrize get(int index) {
        return value.get(index);
    }
}

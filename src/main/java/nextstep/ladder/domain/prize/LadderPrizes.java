package nextstep.ladder.domain.prize;

import java.util.List;
import java.util.Objects;
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
        return value.stream()
            .map(LadderPrize::getValue)
            .collect(Collectors.toList());
    }

    public LadderPrize get(int index) {
        return value.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPrizes that = (LadderPrizes) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

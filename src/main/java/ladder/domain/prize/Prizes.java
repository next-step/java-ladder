package ladder.domain.prize;

import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(final List<String> names) {
        validateNames(names);
        this.prizes = names.stream()
                .map(Prize::of)
                .collect(Collectors.toList());
    }

    public static Prizes of(List<String> names) {
        return new Prizes(names);
    }

    private void validateNames(final List<String> names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public int count() {
        return this.prizes.size();
    }

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toList());
    }

    public Prize indexOf(final int index) {
        return prizes.get(index);
    }
}

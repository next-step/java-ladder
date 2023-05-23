package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningCategories {

    private static final String SPLIT_REGEX = ",";
    private final List<WinningCategory> winningCategories = new ArrayList<>();

    public WinningCategories(String input) {
        String[] winningCategories = input.split(SPLIT_REGEX);
        Arrays.stream(winningCategories).forEach((name) -> this.winningCategories.add(new WinningCategory(name)));
    }

    protected int size() {
        return this.winningCategories.size();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCategories that = (WinningCategories) o;
        return Objects.equals(winningCategories, that.winningCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningCategories);
    }

    @Override
    public String toString() {
        return winningCategories.stream().map(WinningCategory::toString).collect(Collectors.joining(""));
    }
}

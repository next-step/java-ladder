package ladder.domain.ladder;

import ladder.utils.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Awards {

    private static final String COMMA = ",";
    private static final int MIN_SIZE = 2;
    private static final int ZERO = 0;

    private final List<Award> awards;

    private Awards(List<Award> awards) {
        validateAwardsSize(awards);
        this.awards = awards;
    }

    public static Awards of(String namesOfAwards) {
        validateBlank(namesOfAwards);
        return Arrays.stream(namesOfAwards.split(COMMA))
                .map(Award::new)
                .collect(collectingAndThen(toList(), Awards::new));
    }

    private void validateAwardsSize(List<Award> awards) {
        if (awards.isEmpty() || awards.size() < MIN_SIZE) {
            throw new AwardsSizeException(awards.size());
        }
    }

    private static void validateBlank(String namesOfAwards) {
        if (StringUtil.isBlank(namesOfAwards)) {
            throw new AwardsSizeException(ZERO);
        }
    }

    public int size() {
        return awards.size();
    }

    public String name(int indexOfAward) {
        return awards.get(indexOfAward).name();
    }

    public List<Award> getAwards() {
        return Collections.unmodifiableList(awards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Awards awards1 = (Awards) o;
        return Objects.equals(awards, awards1.awards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awards);
    }
}

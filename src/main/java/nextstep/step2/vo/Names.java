package nextstep.step2.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Names {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final String NULL_OR_LESS_SIZE_MESSAGE = "최소 " + MIN_PLAYER_COUNT + "명 이상의 플레이어가 필요합니다.";

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names create(List<Name> names) {

        if (names == null || names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return new Names(names);
    }

    public static Names createWithString(String input) {

        if (input == null) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return Arrays.stream(input.split(","))
                .map(Name::create)
                .collect(collectingAndThen(toList(), Names::new));
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return names.stream()
                .map(name -> Name.create(name.getValue()))
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}

package nextstep.ladder.domain;

import nextstep.ladder.dto.NamesDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public static Names of(String names) {
        List<Name> collect = Arrays.stream(names.split(","))
                .map(Name::from)
                .collect(Collectors.toList());
        return new Names(collect);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    public int size() {
        return names.size();
    }

    public NamesDto toDto() {
        return names.stream()
                .map(Name::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), NamesDto::new));
    }
}

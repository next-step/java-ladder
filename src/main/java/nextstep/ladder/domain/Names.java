package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.exception.NotExistNameException;

public class Names {

    private List<Name> names;

    public Names(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("참가자는 최소 두명 이상부터 가능함.");
        }

        this.names = names.stream()
            .map(Name::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<String> get() {
        return names.stream()
            .map(Name::get)
            .collect(Collectors.toUnmodifiableList());
    }

    public int indexOf(final String name) {
        return IntStream.range(0, names.size())
            .filter(value -> names.get(value).get().equals(name))
            .boxed()
            .findAny()
            .orElseThrow(() -> new NotExistNameException("찾으려는 이름이 없음"));
    }

    @Override
    public String toString() {
        return "Names{" + names +
            "}\n";
    }
}

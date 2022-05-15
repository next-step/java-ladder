package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.exception.NotExistNameException;

public class Names {

    private List<Name> names;

    public Names(List<String> names) {
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

}

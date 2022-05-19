package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.NotExistNameException;

public class Names {

    private static final String MINIMUM_PARTICIPANTS = "참가자는 최소 두명 이상부터 가능함.";
    private static final String NO_PARTICIPANTS = "찾으려는 참가자 이름이 없음.";
    private List<Name> names;

    public Names(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(MINIMUM_PARTICIPANTS);
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

    public int indexOf(final Name name) {
        if (!names.contains(name)) {
            throw new NotExistNameException(NO_PARTICIPANTS);
        }

        return names.indexOf(name);
    }

    @Override
    public String toString() {
        return "Names{" + names +
            "}\n";
    }

    public int size() {
        return names.size();
    }
}

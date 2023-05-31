package nextstep.ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private boolean hasDuplicateName(List<String> names) {
        Set<String> namesSet = new HashSet<>(names);
        return namesSet.size() < names.size();
    }

    public int getOrderOf(String nameToShowResult) {
        int order = this.names.indexOf(new Name(nameToShowResult));
        if (order == -1) {
            throw new IllegalArgumentException("참여하지 않은 사람입니다. (" + nameToShowResult + ")");
        }
        return order;
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }
}

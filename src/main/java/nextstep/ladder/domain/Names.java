package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<String> persons) {
        this.names = persons.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public Name name(int index){
        return names.get(index);
    }

    public int countOfParticipant() {
        return names.size();
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }

}

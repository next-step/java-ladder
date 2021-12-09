package ladder.model.name;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(String names){
        this.names = Arrays.stream(names.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
        checkValidation(this.names);
    }

    public List<Name> get() {
        return Collections.unmodifiableList(this.names);
    }

    private void checkValidation(List<Name> names) {
        if(names.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 이거나 비어있습니다.");
        }
        if(new HashSet(names).size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}

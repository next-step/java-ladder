package ladder.model.stringas;

import ladder.model.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAsNames {

    private final String names;

    public StringAsNames(String names){
        this.names = names;
    }

    public List<Name> get() {
        List<Name> list = Arrays.stream(names.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
        checkValidation(list);
        return list;
    }

    private void checkValidation(List<Name> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 이거나 비어있습니다.");
        }
    }
}
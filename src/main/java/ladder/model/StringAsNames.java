package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAsNames implements Names {

    private final String names;

    public StringAsNames(String names){
        this.names = names;
    }

    @Override
    public List<Name> names() {
        return Arrays.stream(names.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }
}

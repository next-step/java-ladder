package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private List<String> names;

    public Users(String names) {
        this(Arrays.stream(names.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList()));
    }

    public Users(List<String> names) {
        this.names = names;
    }

}

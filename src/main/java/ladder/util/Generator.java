package ladder.util;

import ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Generator {
    public static List<User> generate(String commaNames) {
        return stream(commaNames.split(","))
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }
}

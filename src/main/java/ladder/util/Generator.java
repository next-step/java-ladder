package ladder.util;

import ladder.domain.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Generator {

    public static List<User> userGenerate(String commaNames) {
        AtomicInteger index = new AtomicInteger();

        return stream(commaNames.split(","))
                .map(name -> new User(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public static List<String> resultGenerate(String commaNames) {
        return stream(commaNames.split(","))
                .collect(Collectors.toList());
    }
}

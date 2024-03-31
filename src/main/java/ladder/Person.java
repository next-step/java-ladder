package ladder;

import java.util.Optional;

public class Person {
    private Optional<String> name;

    public Person(String name) {
        Optional<String> optionalName = Optional.of(name);
        optionalName
                .filter(n -> n.length() <= 5)
                .orElseThrow(() -> new IllegalArgumentException("이름이 5자를 초과하였습니다."));

        this.name = optionalName;
    }
}

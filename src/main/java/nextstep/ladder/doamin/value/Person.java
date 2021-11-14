package nextstep.ladder.doamin.value;

import nextstep.ladder.utils.Preconditions;

import java.util.Objects;

public class Person {
    private static final Integer MAXIMUM_NAME_SIZE = 5;

    private final String name;

    private Person(String name) {
        Preconditions.checkString(name, "name은 필수값입니다.");
        Preconditions.checkMaximumSize(name.length(),
                                       MAXIMUM_NAME_SIZE, String.format("name의 길이는 %s 이하 이어야 합니다.", MAXIMUM_NAME_SIZE));

        this.name = name;
    }

    public static Person from(String name) {
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

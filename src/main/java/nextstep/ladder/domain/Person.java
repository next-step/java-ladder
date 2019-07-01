package nextstep.ladder.domain;

import java.util.Objects;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Person {
    private String name;

    private Person() {
    }

    public Person(String name) {
        if (Objects.isNull(name) || "".equals(name)) {
            throw new IllegalArgumentException("이름은 공백이거나 null일수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자 까지 입력 가능합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
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

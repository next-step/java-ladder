package nextstep.domain.person;

import java.util.Objects;

public class Person {

    private final int trackNumber;
    private final String name;

    public Person(String name) {
        this(-1, name);
    }

    public Person(int trackNumber, String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다.");
        }
        this.trackNumber = trackNumber;
        this.name = name;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getName() {
        return name;
    }

    public static boolean validateName(String name) {
        return PersonValidator.validateName(name);
    }

    public Person finish(int finishTrackNumber) {
        return new Person(finishTrackNumber, name);
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

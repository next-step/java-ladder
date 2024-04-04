package ladder.domain;

import java.util.Objects;

public class Participant {

    private final String name;

    public Participant(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        this.name = name;
    }

    public String name(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

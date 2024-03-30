package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if("".equals(name)){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        if(this.name.length() >= 5){
            return this.name;
        }
        String substring = "     ".substring(0, 5 - name.length());
        return substring + this.name;
    }
}

package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ParticipatePeople {
    private final List<String> participatePerson;

    public ParticipatePeople(List<String> participatePerson) {
        this.participatePerson = participatePerson;
    }

    public static ParticipatePeople of(List<String> participatePerson) {
        return new ParticipatePeople(participatePerson);
    }

    public List<String> getList(){
        return Collections.unmodifiableList(participatePerson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipatePeople that = (ParticipatePeople) o;
        return Objects.equals(participatePerson, that.participatePerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participatePerson);
    }
}

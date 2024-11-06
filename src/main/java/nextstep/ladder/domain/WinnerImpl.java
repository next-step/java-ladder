package nextstep.ladder.domain;

import nextstep.ladder.engine.Person;
import nextstep.ladder.engine.Winner;

import java.util.Objects;

public class WinnerImpl implements Winner {
    private final Person person;
    private final String result;

    public WinnerImpl(final Person person, final String result) {
        this.person = person;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return person.name();
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerImpl winnerImpl = (WinnerImpl) o;
        return Objects.equals(person, winnerImpl.person) && Objects.equals(result, winnerImpl.result);
    }
}

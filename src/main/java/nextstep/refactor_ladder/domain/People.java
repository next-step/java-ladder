package nextstep.refactor_ladder.domain;

import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {
    private final List<Person> personList;

    public People(List<Person> personList) {
        Preconditions.checkEmpty(personList, "personList는 필수값입니다.");

        this.personList = personList;
    }

    public static People from(List<Person> personList) {
        return new People(personList);
    }

    public int getPersonIndex(Person personName) {
        return personList.indexOf(personName);
    }

    public List<Person> getPersonList() {
        return Collections.unmodifiableList(new ArrayList<>(personList));
    }
}

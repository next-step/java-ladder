package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {
    private static final Integer WRONG_NAME_INDEX = -1;
    private final List<Person> personList;

    public People(List<Person> personList) {
        Preconditions.checkEmpty(personList, "personList는 필수값입니다.");

        this.personList = personList;
    }

    public static People from(List<Person> personList) {
        return new People(personList);
    }

    public Integer count() {
        return personList.size();
    }

    public Location getLocation(Person personName) {
        return Location.from(personList.indexOf(personName));
    }

    public boolean isCorrectName(Person personName) {
        return !Location.from(WRONG_NAME_INDEX).equals(getLocation(personName));
    }

    @GetterForUI
    public List<Person> getPersonList() {
        return Collections.unmodifiableList(new ArrayList<>(personList));
    }
}

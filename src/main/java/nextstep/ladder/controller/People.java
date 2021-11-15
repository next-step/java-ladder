package nextstep.ladder.controller;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People {
    private final List<Person> people;

    public People(List<Person> people) {
        Preconditions.checkEmpty(people, "people는 필수값입니다.");

        this.people = people;
    }

    public static People from(List<Person> people) {
        return new People(people);
    }

    public Integer count() {
        return people.size();
    }

    @GetterForUI
    public List<Person> getPoints() {
        return Collections.unmodifiableList(new ArrayList<>(people));
    }
}

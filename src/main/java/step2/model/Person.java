package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final static String MINIMUM_PERSON_COUNT_MESSAGE = "참여 인원은 2명이상이여야 합니다.";
    private final static int MINIMUM_PERSON_COUNT = 2;

    private final List<Name> names = new ArrayList<>();

    private Person(String[] personArr) {
        confirmPersonCount(personArr);
        for(String name : personArr) {
            names.add(Name.createName(name));
        }
    }

    public static Person createPerson(String[] personArr) {
        return new Person(personArr);
    }

    public int nameSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }

    //참여하는 인원수를 체크한다.
    private void confirmPersonCount(String[] personArr) {
        if (personArr.length < MINIMUM_PERSON_COUNT) {
            throw new IllegalArgumentException(MINIMUM_PERSON_COUNT_MESSAGE);
        }
    }

}

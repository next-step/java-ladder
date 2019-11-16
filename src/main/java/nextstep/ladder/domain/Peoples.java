package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Peoples {
    private static final String PEOPLE_STRING_SEPARATOR = ",";
    private static final String NO_SEARCH_PEOPLE_MESSAGE = "참가하지 않은 사용자 입니다.";
    private static final String ALL_RESULT_PEOPLE = "all";

    private List<People> peoples;

    public Peoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public static Peoples of(String string) {
        String[] names = string.split(PEOPLE_STRING_SEPARATOR);
        List<People> peoples = new ArrayList<>();

        for (String name : names) {
            peoples.add(new People(name.trim()));
        }

        return new Peoples(peoples);
    }

    public int size() {
        return peoples.size();
    }

    public People peopleByIndex(int index) {
        return peoples.get(index);
    }

    public Peoples getResultPeoples(String name) {
        if (ALL_RESULT_PEOPLE.equalsIgnoreCase(name)) {
            return this;
        }

        return getPeoplesByResultName(name);
    }

    private Peoples getPeoplesByResultName(String name) {
        People resultPeople = peoples.stream()
                .filter(people -> people.isSamePeople(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NO_SEARCH_PEOPLE_MESSAGE));
        return new Peoples(Collections.singletonList(resultPeople));
    }
}

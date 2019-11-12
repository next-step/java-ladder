package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Peoples {
    private static final String PEOPLE_STRING_SEPARATOR = ",";

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
}

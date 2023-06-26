package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Peoples {
    private List<People> peoples = new ArrayList<>();

    public Peoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public int manyPeople() {
        return peoples.size();
    }

    public List<People> getPeoples() {
        return peoples;
    }
}

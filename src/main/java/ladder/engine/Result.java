package ladder.engine;

import java.util.*;

public class Result {

    Map<Integer, Integer> value;

    public Result() {
        this(new HashMap<>());
    }

    public Result(Map<Integer, Integer> value) {
        this.value = new HashMap<>(value);
    }

    public void put(Integer personOrder, Integer goalOrder) {
        value.put(personOrder, goalOrder);
    }

    public Integer get(Integer personOrder) {
        return value.get(personOrder);
    }

    public Set<Integer> keySet() {
        return value.keySet();
    }
}

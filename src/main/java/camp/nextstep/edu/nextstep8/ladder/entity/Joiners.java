package camp.nextstep.edu.nextstep8.ladder.entity;

import camp.nextstep.edu.nextstep8.ladder.JoinersConvertor;

import java.util.Collections;
import java.util.List;

public class Joiners {
    private final List<String> joiners;

    public Joiners(String input) {
        this.joiners = JoinersConvertor.makeJoiners(input);
    }

    public int count() {
        return joiners.size();
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(joiners);
    }
}

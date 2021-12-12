package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Compensations {
    private List<String> compensations;

    public List<String> getCompensations() {
        return compensations;
    }

    private Compensations(List<String> compensations) {
        this.compensations = compensations;
    }

    public static Compensations of(String compensationString) {
        return new Compensations(Arrays.asList(compensationString.split(",")));
    }
}

package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participators {

    private List<Participator> participators;

    private Participators(List<Participator> participators) {
        this.participators = participators;
    }

    public static Participators from(List<String> names) {
        return new Participators(names.stream()
                .map(Participator::new)
                .collect(Collectors.toList()));
    }

    public List<Participator> getParticipators() {
        return participators;
    }
}

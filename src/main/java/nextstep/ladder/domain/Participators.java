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

    public int participatorCount() {
        return participators.size();
    }

    public List<Participator> getParticipators() {
        return participators;
    }

    @Override
    public String toString() {
        return participators.stream().map(Participator::makeFullName)
                .collect(Collectors.joining());
    }
}

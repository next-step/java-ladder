package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participators {

    private List<Participator> participators;

    private Participators(List<Participator> participators) {
        this.participators = participators;
    }

    public static Participators from(List<String> names) {
        return new Participators(IntStream.range(0, names.size())
                .mapToObj(loc -> new Participator(names.get(loc), loc))
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

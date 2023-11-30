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

    public void playLadder(Ladder ladder) {
        participators.forEach(participator -> ladder.getLines().forEach(participator::goLadderOneLine));
    }

    public int findParticipatorLocation(String name) {
        Participator resultParticipator = participators.stream()
                .filter(participator -> participator.hasName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
        return resultParticipator.getLocation();
    }

    public int participatorCount() {
        return participators.size();
    }

    public List<Participator> getParticipators() {
        return participators;
    }

    public String getName(int index) {
        return participators.get(index).getName();
    }

    public Participator getParticipator(int index) {
        return participators.get(index);
    }

    @Override
    public String toString() {
        return participators.stream().map(Participator::makeFullName)
                .collect(Collectors.joining());
    }
}

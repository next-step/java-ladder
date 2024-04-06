package ladder.domain.participants.factory;

import ladder.domain.participants.Gamer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParticipantsFactory {

    private ParticipantsFactory() {
    }

    public static List<Gamer> generateGamers(String[] names) {
        return IntStream.range(0, names.length).mapToObj(num -> new Gamer(names[num], num)).collect(Collectors.toList());
    }
}

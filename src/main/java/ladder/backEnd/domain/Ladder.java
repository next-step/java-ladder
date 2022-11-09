package ladder.backEnd.domain;

import ladder.backEnd.streategy.RandomConnection;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {
    public Lines create(List<String> countOfName, int height) {
        Names names = Names.create(countOfName);
        return IntStream.range(0, height)
                .boxed()
                .map(bridge -> new Line(names.howManyPerson(), new RandomConnection()))
                .collect(collectingAndThen(toList(), Lines::new));
    }
}

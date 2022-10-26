package ladder;

import ladder.domain.person.Person;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.ladder.strategy.LadderConnectStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderService {

    private final LadderLineFactory ladderLineFactory;

    public LadderService(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
    }

    public LadderLines createLadderLine(int width, int height) {
        return ladderLineFactory.randomLadderLines(new LadderWidth(width), new LadderHeight(height));
    }

    public List<Person> persons(String[] strings) {
        return Arrays.stream(strings)
                .map(Person::new)
                .collect(Collectors.toList());
    }
}

package ladder.domain;

import ladder.domain.common.Printable;
import ladder.domain.element.Person;
import ladder.domain.element.Persons;
import ladder.domain.line.DrawStrategy;
import ladder.domain.line.LadderLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.common.LadderMessage.LADDER_HEIGHT_MESSAGE;

public class Ladder implements Printable {

    private final List<LadderLine> ladderLines = new ArrayList<>();
    private final Map<Person, Integer> personMap = new HashMap<>();

    public Ladder(Persons persons, int height, DrawStrategy drawStrategy) {
        checkArgument(height > 0, LADDER_HEIGHT_MESSAGE);

        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.of(persons.size(), drawStrategy));
        }

        for (int i = 0; i < persons.size(); i++) {
            personMap.put(persons.get(i), i);
        }
    }

    public int lineDown(Person person) {
        int startPosition = personMap.get(person);
        for (LadderLine ladderLine : ladderLines) {
            startPosition = ladderLine.move(startPosition);
        }
        return startPosition;
    }

    public int height() {
        return ladderLines.size();
    }

    @Override
    public String print() {
        return ladderLines.stream()
                .map(LadderLine::print)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

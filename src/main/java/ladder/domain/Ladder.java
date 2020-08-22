package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static ladder.domain.LadderMessage.LADDER_HEIGHT_MESSAGE;

public class Ladder implements Printable {

    private final List<LadderLine> ladderLines = new ArrayList<>();

    public Ladder(Persons persons, int height, DrawStrategy drawStrategy) {
        checkArgument(height > 0, LADDER_HEIGHT_MESSAGE);

        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.of(persons.size(), drawStrategy));
        }
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

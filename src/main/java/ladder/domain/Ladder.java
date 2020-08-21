package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

public class Ladder implements Printable {

    public static final String LADDER_HEIGHT_MESSAGE = "The ladder height must be greater than zero";

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

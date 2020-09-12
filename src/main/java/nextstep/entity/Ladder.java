package nextstep.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<Line> lines = new ArrayList<>();

    private Ladder() {
    }

    public void initLadder(Personnel personnel, Length length) {
        IntStream.range(START_INDEX, length.getLength())
                .forEach(index -> lines.add(Line.of(personnel.getPersonnel())));
    }

    public List<List<Boolean>> getLinesStatus() {
        return this.lines.stream().map(Line::getPedalsStatus).collect(Collectors.toList());
    }

    public static Ladder of() {
        return new Ladder();
    }

    private int play(int targetIndex) {
        AtomicInteger previousIndex = new AtomicInteger(targetIndex);
        lines.forEach(line -> {
            int nextIndex = line.play(previousIndex.get());
            previousIndex.set(nextIndex);
        });
        return previousIndex.get();
    }

    public PlayResults play(Entries startEntries, Entries arrivalEntries) {
        List<PlayResult> playResults = IntStream.range(START_INDEX, startEntries.getPersonnel())
                .mapToObj(index -> {
                    Entry startEntry = startEntries.getEntryByIndex(index);
                    Entry arrivalEntry = arrivalEntries.getEntryByIndex(play(index));
                    return PlayResult.of(startEntry.getName(), arrivalEntry.getName());
                })
                .collect(Collectors.toList());
        return PlayResults.of(playResults);
    }
}

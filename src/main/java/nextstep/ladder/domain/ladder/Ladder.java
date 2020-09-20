package nextstep.ladder.domain.ladder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public static Ladder from(LadderMaterial ladderMaterial) {
        return IntStream.range(0, ladderMaterial.getHeight())
                .mapToObj(i -> Line.from(ladderMaterial.getLineMaterial()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));

    }

    private Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(Collections.unmodifiableList(lines));
    }

    public LadderResult play() {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int sizeOfPoint = lines.get(0).sizeOfPoint();
        Map<Location, Location> playResult = play(sizeOfPoint);
        return new LadderResult(playResult);
    }

    private Map<Location, Location> play(final int sizeOfPoint) {
        Map<Location, Location> result = new HashMap<>();
        IntStream.range(0, sizeOfPoint)
                .forEach(location -> {
                    Location startLocation = Location.from(location);
                    result.put(startLocation, getFinalLocation(startLocation));
                });
        return result;
    }

    private Location getFinalLocation(final Location startLocation) {
        Location finalLocation = startLocation;
        for (Line line : lines) {
            finalLocation = line.move(finalLocation);
        }
        return finalLocation;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}

package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        Preconditions.checkEmpty(lines, "lines는 필수값입니다.");

        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public Location getLadderResult(Location personLocation) {
        AtomicReference<Location> lastLocation = new AtomicReference<>(personLocation);
        lines.forEach(line -> lastLocation.set(line.getCurrentLocation(lastLocation.get())));
        return lastLocation.get();
    }

    @GetterForUI
    public List<Line> getLines() {
        return Collections.unmodifiableList(new ArrayList<>(lines));
    }
}

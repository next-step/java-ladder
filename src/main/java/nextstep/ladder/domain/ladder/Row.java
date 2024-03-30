package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private final List<Rung> rungs = new ArrayList<>();

    public Row(Count playersCount, RungGenerateStrategy strategy) {
        this.rungs.addAll(generateRungs(playersCount, strategy));
    }

    private List<Rung> generateRungs(Count playersCount, RungGenerateStrategy strategy) {
        final AtomicBoolean lastFlag = new AtomicBoolean(false);

        return IntStream.range(0, playersCount.subtract(1).value())
                .mapToObj(idx -> generateRung(strategy, lastFlag))
                .collect(Collectors.toList());
    }

    private Rung generateRung(RungGenerateStrategy strategy, AtomicBoolean lastFlag) {
        final Rung rung = Rung.generate(strategy, Rung.findByBoolean(lastFlag.get()));

        lastFlag.set(rung.exist());

        return rung;
    }

    public List<Rung> rungs() {
        return Collections.unmodifiableList(rungs);
    }
}

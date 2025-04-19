package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.DefaultRandomPointGenerator;
import nextstep.ladder.strategy.RandomPointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    
    public static Ladder create(final Players players, final Height height) {
        return create(players, height, new DefaultRandomPointGenerator());
    }
    
    public static Ladder create(final Players players, final Height height, final RandomPointGenerator pointGenerator) {
        return new Ladder(createLines(players, height, pointGenerator));
    }
    
    private static List<Line> createLines(final Players players, final Height height, final RandomPointGenerator pointGenerator) {
        return IntStream.range(0, height.getValue())
                .mapToObj(i -> new Line(players, pointGenerator))
                .collect(Collectors.toList());
    }
} 

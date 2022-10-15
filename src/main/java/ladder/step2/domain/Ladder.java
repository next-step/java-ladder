package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.PartLineCreateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;
    
    private Ladder(final List<Line> ladder) {
        this.ladder = ladder;
    }
    
    public static Ladder of(final int ladderHeight, final int countOfPlayers, final PartLineCreateStrategy partLineCreateStrategy) {
        return new Ladder(init(ladderHeight, countOfPlayers, partLineCreateStrategy));
    }
    
    private static List<Line> init(final int ladderHeight, final int countOfPlayers, final PartLineCreateStrategy partLineCreateStrategy) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(count -> Line.of(countOfPlayers, partLineCreateStrategy))
                .collect(Collectors.toList());
    }
    
    public int move(int position) {
        for (Line line : ladder) {
            position = line.move(position);
        }
        
        return position;
    }
    
    @Override
    public String toString() {
        return "Ladder{" +
                "ladder=" + ladder +
                '}';
    }
}

package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private LineBuildStrategy lineBuildStrategy;


    public LadderGame(LineBuildStrategy lineBuildStrategy) {
        this.lineBuildStrategy = lineBuildStrategy;
    }

    public Ladders start(int ladderCount, int ladderMaxHeight){
        return build(ladderCount, ladderMaxHeight);
    }

    private Ladders build(int ladderCount, int ladderMaxHeight) {

        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(ladderCount)))
                .collect(Collectors.toList()));


        return ladders;
    }
}

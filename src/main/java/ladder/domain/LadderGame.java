package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.LadderGameConfig.MIN_LADDER_HEIGHT;

public class LadderGame {

    private LineBuildStrategy lineBuildStrategy;


    public LadderGame(LineBuildStrategy lineBuildStrategy) {
        this.lineBuildStrategy = lineBuildStrategy;
    }

    public Ladders start(int ladderCount, int ladderMaxHeight){
        validateLadderMinHeight(ladderMaxHeight);
        return build(ladderCount, ladderMaxHeight);
    }

    private void validateLadderMinHeight(int ladderMaxHeight) {
        if(ladderMaxHeight < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException(LadderGameErrorMessage.OVER_MIN_HEIGHT.getErrorMessage());
        }
    }

    private Ladders build(int ladderCount, int ladderMaxHeight) {

        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(ladderCount)))
                .collect(Collectors.toList()));


        return ladders;
    }
}

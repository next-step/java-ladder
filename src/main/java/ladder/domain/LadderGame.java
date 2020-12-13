package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final int MIN_LADDER_HEIGHT = 1;

    public Ladders start(int ladderCount, int ladderMaxHeight){
        validateLadderMinHeight(ladderMaxHeight);
        return build(ladderCount, ladderMaxHeight);
    }

    private void validateLadderMinHeight(int ladderMaxHeight) {
        if(ladderMaxHeight < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException("최소 사다리 높이는 "+MIN_LADDER_HEIGHT+" 입니다.");
        }
    }

    private Ladders build(int ladderCount, int ladderMaxHeight) {

        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(ladderCount))
                .collect(Collectors.toList()));


        return ladders;
    }
}

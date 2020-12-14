package ladder.domain;


public class LadderGame {

    private static final int MIN_LADDER_HEIGHT = 1;

    public Ladder build(int sizeOfPerson, int ladderMaxHeight){
        validateLadderMinHeight(ladderMaxHeight);
        return new Ladder(sizeOfPerson, ladderMaxHeight);
    }

    private void validateLadderMinHeight(int ladderMaxHeight) {
        if(ladderMaxHeight < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException("최소 사다리 높이는 "+MIN_LADDER_HEIGHT+" 입니다.");
        }
    }

}

package nextstep.ladder.domain;

public class LadderGame {



    public Ladder createLadder(LadderGameSettings settings) {
        return Ladder.from(settings);
    }


}

package nextstep.ladder.domain;

public class LadderGame {

    public static Ladder createLadder(LadderGameSettings settings) {
        return Ladder.from(settings);
    }

}

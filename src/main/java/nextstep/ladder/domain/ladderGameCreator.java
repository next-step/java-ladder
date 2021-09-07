package nextstep.ladder.domain;

public class ladderGameCreator {

    public static LadderGame createGame(LadderGameSettings settings) {
        return LadderGame.from(settings);
    }

}

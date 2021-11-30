package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;

    private LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public static LadderGame of(GameInfoDto gameInfoDto, Ladder ladder) {
        return new LadderGame(GameInfo.of(gameInfoDto.getNames(), gameInfoDto.getGifts()), ladder);
    }

    public Ladder getLadder() {
        return ladder;
    }

//    public Names getNames() {
//        return names;
//    }
}

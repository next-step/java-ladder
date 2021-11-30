package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.vo.Gift;
import nextstep.step2.vo.Name;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGame that = (LadderGame) o;
        return Objects.equals(gameInfo, that.gameInfo) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameInfo, ladder);
    }

    public Gift playGame(Name name) {
        Point start = gameInfo.findStartPoint(name)
                .orElseThrow(IllegalArgumentException::new);

        Point end = ladder.play(start);

        return gameInfo.findGiftWithPoint(end);
    }
}

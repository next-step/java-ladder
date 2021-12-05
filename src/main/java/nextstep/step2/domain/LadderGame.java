package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.GameResult;
import nextstep.step2.dto.GameResults;
import nextstep.step2.vo.Gifts;
import nextstep.step2.vo.Name;
import nextstep.step2.vo.Names;

import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;

    private LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public static LadderGame of(GameInfo gameInfo, Ladder ladder) {
        return new LadderGame(gameInfo, ladder);
    }

    public static LadderGame ofWithGamInfoDtoAndLadder(GameInfoDto gameInfoDto, Ladder ladder) {
        return of(GameInfo.of(Names.fromWithString(gameInfoDto.getNames()), Gifts.fromWithString(gameInfoDto.getGifts())), ladder);
    }


    public Ladder getLadder() {
        return ladder;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public GameResult playGame(Name name) {
        Point start = gameInfo.findStartPoint(name)
                .orElseThrow(IllegalArgumentException::new);

        Point end = ladder.play(start);

        return new GameResult(name, gameInfo.findGiftWithPoint(end));
    }

    public GameResults playAllGame() {
        return gameInfo.namesList().stream()
                .map(this::playGame)
                .collect(Collectors.collectingAndThen(Collectors.toList(), GameResults::new));
    }

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
}

package nextstep.ladder.domain;

import nextstep.ladder.domain.dto.LadderPlayerGameResult;
import nextstep.ladder.domain.dto.LadderResult;
import nextstep.ladder.domain.dto.PlayerRecord;
import nextstep.ladder.domain.element.Ladder;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.domain.play.PlayResult;
import nextstep.ladder.domain.play.PlayerPosition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class LadderGame {
    private final GameElement gameElement;
    private final Ladder ladder;

    private LadderGame(LadderGameInfo ladderGameInfo) {
        validate(ladderGameInfo);

        this.gameElement = ladderGameInfo.getGameElement();
        this.ladder = Ladder.create(ladderGameInfo.getLadderInfo());
    }

    private void validate(LadderGameInfo ladderGameInfo) {
        if (Objects.isNull(ladderGameInfo)) {
            throw new IllegalArgumentException("LadderGameInfo는 null이면 안된다");
        }
    }

    public static LadderGame of(LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladderGameInfo);
    }

    public LadderResult resultLadderFigure() {
        return LadderResult.of(gameElement, ladder.getFigures());
    }

    public LadderPlayerGameResult play() {
        PlayResult playResult = playLadderGame();
        return LadderPlayerGameResult.of(makePlayerGameResult(playResult));
    }

    private PlayResult playLadderGame() {
        return ladder.move();
    }

    private Map<String, PlayerRecord> makePlayerGameResult(PlayResult playResult) {
        Map<String, PlayerRecord> playerGameResult = new HashMap<>();
        IntStream.range(0, gameElement.getPlayerCount())
                .forEach(makeResult(playerGameResult, playResult));
        return playerGameResult;
    }

    private IntConsumer makeResult(Map<String, PlayerRecord> playerGameResult, PlayResult playResult) {
        return playerPosition -> {
            PlayerPosition position = PlayerPosition.of(playerPosition);
            playerGameResult.put(
                    gameElement.getPlayerNameAt(position),
                    PlayerRecord.of(gameElement.getResultAt(playResult.result(position)))
            );
        };
    }
}

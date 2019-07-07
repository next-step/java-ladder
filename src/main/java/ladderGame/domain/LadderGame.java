package ladderGame.domain;

import ladderGame.dto.GameInformation;
import ladderGame.dto.LadderGameResult;
import ladderGame.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Ladder ladder;
    private final GameInformation gameInformation;

    private LadderGame(Ladder ladder, GameInformation gameInformation) {
        this.ladder = ladder;
        this.gameInformation = gameInformation;
    }

    public static LadderGame of(Ladder ladder, GameInformation gameInformation) {
        return new LadderGame(ladder, gameInformation);
    }

    public LadderGameResult run() {
        List<Position> positions = IntStream.range(0, gameInformation.getNumberOfPlayer())
                .mapToObj(index -> ladder.ride(new Position(index)))
                .collect(Collectors.toList());
        return buildGameResult(positions);
    }

    private LadderGameResult buildGameResult(List<Position> positions) {
        List<ResultDto> results = IntStream.range(0, positions.size())
                .mapToObj(position -> buildDto(new Position(position), positions.get(position)))
                .collect(Collectors.toList());
        return new LadderGameResult(results);
    }

    private ResultDto buildDto(Position startPosition, Position resultPosition) {
        String name = gameInformation.getPlayerNameByPosition(startPosition);
        String content = gameInformation.getResultByPosition(resultPosition);
        return ResultDto.of(name, content);
    }
}

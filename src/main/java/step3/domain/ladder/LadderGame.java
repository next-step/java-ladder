package step3.domain.ladder;

import step3.domain.ladder.dto.LadderBuildDTO;
import step3.domain.ladder.dto.LadderGameInformationDTO;
import step3.domain.ladder.dto.LadderResultDTO;
import step3.domain.ladder.dto.PlayerWinningInfo;
import step3.strategy.MakeLineStrategy;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderGame {

    public static final String DELIMITER = ",";
    public static final String SPACE = "";

    private LadderGame() { }

    public static LadderPlayers join(String input) {
        isValid(input);

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(LadderGame::isNotEmpty)
                .collect(collectingAndThen(Collectors.toList(), LadderPlayers::of));
    }

    private static void isValid(String input) {
        if (Objects.isNull(input) || input.equals(SPACE)) {
            throw new NoSuchElementException();
        }
    }

    private static boolean isNotEmpty(String name) {
        return !name.equals(SPACE);
    }

    public static Ladder makeLadder(LadderBuildDTO buildDTO, MakeLineStrategy strategy) {
        return Ladder.of(buildDTO, strategy);
    }

    public static Point play(Player player, Ladder ladder) {
        return ladder.start(player.getPosition());
    }

    public static LadderGameResults playAll(LadderGameInformationDTO gameDTO) {

        return gameDTO.getPlayers()
                .stream()
                .map(player -> {
                    Point resultPoint = play(player, gameDTO.getLadder());
                    LadderResultDTO ladderResultDTO = gameDTO.getLadderResults().resultByPoint(resultPoint.getX());
                    return new PlayerWinningInfo.Builder()
                            .player(player)
                            .point(resultPoint)
                            .winningResult(ladderResultDTO.getResult())
                            .build();
                })
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderGameResults::new));

    }
}

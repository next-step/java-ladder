package ladderGame.util;

import ladderGame.domain.LadderResult;
import ladderGame.domain.LadderResults;
import ladderGame.domain.Player;
import ladderGame.domain.Players;
import ladderGame.dto.LadderGameResult;
import ladderGame.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;


public class LadderResultMapper {


    public static LadderGameResult map(Players players, LadderResults ladderResults) {
        if (players.size() != ladderResults.size()) {
            throw new IllegalArgumentException("크기가 서로 다릅니다.");
        }
        List<ResultDto> results = players.getPlayers().stream()
                .map(player -> mapping(player, ladderResults.getResult(player.getPosition())))
                .collect(Collectors.toList());
        return new LadderGameResult(results);
    }

    private static ResultDto mapping(Player player, LadderResult ladderResult) {
        return ResultDto.of(player.getName(), ladderResult.getContent());
    }
}

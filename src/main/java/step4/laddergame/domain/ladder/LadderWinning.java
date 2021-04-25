package step4.laddergame.domain.ladder;

import step4.laddergame.domain.player.Player;
import step4.laddergame.domain.player.Players;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderWinning {
    private static final String ILLEGAL_FIND_NAME = "결과를 보고싶은 사람의 이름이 목록에는 없습니다.";
    private final Map<Player, Result> winning;

    public LadderWinning() {
        winning = new LinkedHashMap<>();
    }

    public LadderWinning(Map<Player, Result> winning) {
        this.winning = winning;
    }

    public static LadderWinning of(Players players, List<Result> resultList) {
        Map<Player, Result> winning = new LinkedHashMap<>();
        players.match(resultList, winning);
        return new LadderWinning(winning);
    }

    public Result findOne(String name) {
        Result find = winning.get(Player.of(name));
        if (find == null) {
            throw new IllegalArgumentException(ILLEGAL_FIND_NAME);
        }
        return find;
    }

    public Map<Player, Result> getWinning() {
        return Collections.unmodifiableMap(winning);
    }
}

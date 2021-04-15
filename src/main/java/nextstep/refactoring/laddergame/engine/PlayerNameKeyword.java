package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.player.PlayerName;

import java.util.function.Predicate;

public class PlayerNameKeyword {

    private static final String ALL_KEYWORD = "all";

    private final String keyword;

    public PlayerNameKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Predicate<Player> createCondition() {
        return keyword.equals(ALL_KEYWORD) ? player -> true : player -> player.hasName(PlayerName.of(keyword));
    }

}

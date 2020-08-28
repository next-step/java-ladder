package camp.nextstep.edu.rebellion.game;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.rule.RandomDrawingRule;
import camp.nextstep.edu.rebellion.game.custom.CustomLadderGame;
import camp.nextstep.edu.rebellion.game.origin.OriginLadderGame;

public class LadderGameFactory {
    private LadderGameFactory() {}

    public static LadderGame resolve(LadderGameMode mode, Players players, int rows) {
        if (LadderGameMode.ORIGIN == mode) {
            return new OriginLadderGame(players, rows);
        }

        if (LadderGameMode.CUSTOM == mode) {
            return new CustomLadderGame(players, rows, new RandomDrawingRule());
        }

        throw new IllegalArgumentException("mode 에 해당하는 사다리 게임이 존재하지 않습니다");
    }
}

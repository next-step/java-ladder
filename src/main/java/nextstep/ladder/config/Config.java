package nextstep.ladder.config;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.strategy.LineCreatableStrategy;
import nextstep.ladder.strategy.RandomLine;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.View;

public class Config {
    public static LadderController ladderController() {
        return new LadderController(view(), ladderService());
    }

    private static LadderService ladderService() {
        return new LadderService(ladderGame());
    }

    private static LadderGame ladderGame() {
        return new LadderGame(lineCreatableStrategy());
    }

    private static LineCreatableStrategy lineCreatableStrategy() {
        return new RandomLine();
    }

    private static View view() {
        return new View();
    }
}

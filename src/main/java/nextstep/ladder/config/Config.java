package nextstep.ladder.config;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.strategy.LineCreatableStrategy;
import nextstep.ladder.strategy.RandomLine;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.View;

public class Config {
    private static final Config config = new Config();

    private Config() {
    }

    public static Config getInstance() {
        return config;
    }

    public LadderController ladderController() {
        return new LadderController(view(), ladderService());
    }

    private LadderService ladderService() {
        return new LadderService(ladderGame());
    }

    private LadderGame ladderGame() {
        return new LadderGame(lineCreatableStrategy());
    }

    private LineCreatableStrategy lineCreatableStrategy() {
        return new RandomLine();
    }

    private View view() {
        return new View();
    }
}

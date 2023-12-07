package nextstep.ladder.config;

import java.util.Random;
import java.util.Scanner;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.lines.DefaultRandomService;
import nextstep.ladder.domain.lines.RandomLinesFactory;
import nextstep.ladder.domain.lines.RandomService;
import nextstep.ladder.domain.lines.strategy.line.LineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.line.RandomLineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.point.PointCreationStrategy;
import nextstep.ladder.domain.lines.strategy.point.RandomPointCreationStrategy;
import nextstep.ladder.domain.lines.strategy.point.RandomPointsFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class ObjectFactory {

    public InputView inputView() {
        return new InputView();
    }

    public LadderController controller() {
        RandomLinesFactory randomLinesFactory = new RandomLinesFactory(lineCreationStrategy());
        return new LadderController(randomLinesFactory);
    }

    private LineCreationStrategy lineCreationStrategy() {
        RandomPointsFactory randomPointsFactory = new RandomPointsFactory(pointCreationStrategy());
        return new RandomLineCreationStrategy(randomPointsFactory);
    }

    private PointCreationStrategy pointCreationStrategy() {
        return new RandomPointCreationStrategy(randomService());
    }

    private RandomService randomService() {
        return new DefaultRandomService();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}

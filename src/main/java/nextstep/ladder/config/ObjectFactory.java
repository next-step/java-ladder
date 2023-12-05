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
        return new InputView(scanner());
    }

    private Scanner scanner() {
        return new Scanner(System.in);
    }

    public LadderController controller() {
        return new LadderController(randomLinesFactory());
    }

    private RandomLinesFactory randomLinesFactory() {
        return new RandomLinesFactory(lineCreationStrategy());
    }

    private LineCreationStrategy lineCreationStrategy() {
        return new RandomLineCreationStrategy(randomPointsFactory());
    }

    private RandomPointsFactory randomPointsFactory() {
        return new RandomPointsFactory(pointCreationStrategy());
    }

    private PointCreationStrategy pointCreationStrategy() {
        return new RandomPointCreationStrategy(randomService());
    }

    private RandomService randomService() {
        return new DefaultRandomService(random());
    }

    private Random random() {
        return new Random();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}

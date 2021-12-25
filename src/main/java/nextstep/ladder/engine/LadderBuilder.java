package nextstep.ladder.engine;

public interface LadderBuilder {
    Ladder build(int height, LadderPointGenerateStrategy strategy);
}

package nextstep.ladder.engine;

public interface LadderBuilder {
    Ladder build(LadderPointGenerateStrategy strategy);
}

package nextstep.ladder.domain.generator;

@FunctionalInterface
public interface LineGenerator {
    boolean[] lineGenerate(int lineLength);
}

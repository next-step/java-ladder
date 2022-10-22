package ladder.domain;

@FunctionalInterface
public interface LineGenerator {
    Line create(int lineLength);
}

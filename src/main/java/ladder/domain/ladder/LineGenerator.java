package ladder.domain.ladder;

@FunctionalInterface
public interface LineGenerator {
    Line generateLine(int width);
}

package ladder.domain.ladder;

@FunctionalInterface
public interface GeneratorLadderMover {
    Line generateLine(int width);
}

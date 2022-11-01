package ladder.domain;

@FunctionalInterface
public interface LadderPointGenerator {
    void generate(Ladder ladder, int maxLineCount);
}

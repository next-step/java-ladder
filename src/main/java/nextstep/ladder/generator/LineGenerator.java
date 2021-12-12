package nextstep.ladder.generator;

@FunctionalInterface
public interface LineGenerator {
    boolean generate(Boolean prev);
}

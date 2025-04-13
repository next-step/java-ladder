package ladder.domain;

@FunctionalInterface
public interface LineDrawStrategy {
    boolean draw(boolean hasRight);
}

package ladder.domain;

@FunctionalInterface
public interface LinkStrategy {
    boolean tryLink();
}

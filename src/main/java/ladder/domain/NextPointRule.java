package ladder.domain;

@FunctionalInterface
public interface NextPointRule {
    boolean createNextPoint();
}

package nextstep.ladder;

@FunctionalInterface
public interface LineMakeable {
    boolean isMakeable(boolean prevLine, boolean makeCriteria);
}

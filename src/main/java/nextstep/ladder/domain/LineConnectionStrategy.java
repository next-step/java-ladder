package nextstep.ladder.domain;

@FunctionalInterface
public interface LineConnectionStrategy {
    boolean hasConnection(boolean previousRight);
}
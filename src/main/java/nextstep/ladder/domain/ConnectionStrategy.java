package nextstep.ladder.domain;

@FunctionalInterface
public interface ConnectionStrategy {
    boolean connect();
}

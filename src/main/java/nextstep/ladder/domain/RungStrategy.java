package nextstep.ladder.domain;

public interface RungStrategy {
    void apply(Junction curr, Junction right);
}

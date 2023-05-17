package nextstep.ladder.domain;

@FunctionalInterface
public interface PointGenerator {
    Point generate(boolean left, int x);
}

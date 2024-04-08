package nextstep.ladder.domain.line.direction;

@FunctionalInterface
public interface Direction {

    int move(int currentIndex);
}

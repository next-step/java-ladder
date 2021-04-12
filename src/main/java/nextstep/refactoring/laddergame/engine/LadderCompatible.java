package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.ladder.engine.Position;

import java.util.stream.Stream;

public interface LadderCompatible<T extends Positionable> {

    T get(Position position);
    Position locatedIn(T value);
    Stream<T> stream();

}

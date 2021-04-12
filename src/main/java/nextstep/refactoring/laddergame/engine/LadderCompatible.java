package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.ladder.engine.Position;

import java.util.stream.Stream;

public interface LadderCompatible<T> {

    T get(Position position);
    Stream<T> stream();

}

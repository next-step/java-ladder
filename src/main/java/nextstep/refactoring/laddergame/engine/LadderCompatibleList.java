package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Position;

import java.util.stream.Stream;

public interface LadderCompatibleList<T extends Positionable> {

    boolean isNotCompatible(Ladder ladder);
    T get(Position position);
    Stream<T> stream();

}

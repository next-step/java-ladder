package ladder.domain;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import ladder.domain.core.StatefulOperation;
import ladder.domain.core.line.Line;

class LadderStatefulOperation extends StatefulOperation<Line, Integer> {
    LadderStatefulOperation(List<Line> ladder) {
        super(ladder);
    }

    LadderStatefulOperation prepar(String participant) {
        clearState();
        final Function<Line, Integer> participantLine = (e) -> e.indexOf(participant);
        final BiFunction<Line, Integer, Integer> movableLine = Line::indexOf;
        addState(participantLine);
        addState(movableLine);
        return this;
    }

    <T> T result(BiFunction<Line, Integer, T> f) {
        return f.apply(currentTargetElement(), prevState());
    }

    List<String> participants(){
        return target(0)
            .getNames()
            .getPrimitiveNames();
    }

    List<Line> lines(){
        return targets();
    }
}

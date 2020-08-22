package ladder.domain;

import java.util.List;
import java.util.function.BiFunction;

import ladder.domain.core.StatefulOperation;
import ladder.domain.core.line.Line;

class LadderStatefulOperation extends StatefulOperation<Line, Integer> {
    LadderStatefulOperation(List<Line> ladder) {
        super(ladder);
    }

    LadderStatefulOperation prepar(String participant) {
        clearState();
        addState((e) -> e.indexOf(participant));
        addState(Line::indexOf);
        return this;
    }

    <T> T result(BiFunction<Line, Integer, T> f) {
        return f.apply(getCurrentTargetElement(), prevState());
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

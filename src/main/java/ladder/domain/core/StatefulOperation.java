package ladder.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class StatefulOperation<T, V> {
    private final List<T> targets;
    private final List<V> states;

    protected StatefulOperation(List<T> targets) {
        this.targets = targets;
        this.states = new ArrayList<>(targets.size());
    }

    protected T target(int index){
        return targets.get(index);
    }

    protected List<T> targets() {
        return Collections.unmodifiableList(targets);
    }

    protected T currentTargetElement() {
        return targets.get(stateSize());
    }

    protected void clearState(){
        states.clear();
    }

    protected void addState(Function<T, V> stateFunction) {
        this.states.add(stateFunction.apply(currentTargetElement()));
    }

    protected void addState(BiFunction<T, V, V> stateFunction) {
        this.states.add(stateFunction.apply(currentTargetElement(), prevState()));
    }

    protected List<V> states() {
        return Collections.unmodifiableList(states);
    }

    protected V prevState(){
        return state(stateSize() - 1);
    }

    protected V state(int index){
        return states.get(index);
    }

    protected int targetSize() {
        return targets.size();
    }

    protected int stateSize() {
        return states.size();
    }
}

package ladder.model.group;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Group<T> {
    protected final List<T> group;

    protected Group(List<T> group){
        this.group = group;
    }

    public int size(){
        return group.size();
    }

    public List<String> getNames() {
        return group.stream()
                .map(T::toString)
                .collect(Collectors.toList());
    }

    public Stream<T> stream(){
        return group.stream();
    }
}

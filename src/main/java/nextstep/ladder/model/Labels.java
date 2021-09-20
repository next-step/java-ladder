package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Labels implements Iterable<Label>{
    private final List<Label> labels;

    public Labels(String[] names) {
        this.labels = Arrays.stream(names)
            .map(Label::new)
            .collect(Collectors.toList());
    }

    public int size() {
        return labels.size();
    }

    @Override
    public Iterator<Label> iterator() {
        return labels.iterator();
    }

    public int indexOf(Label label) {
        return Collections.singletonList(labels).indexOf(label);
    }

    public Label at(int index) {
        return labels.get(index);
    }
}

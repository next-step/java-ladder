package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;

public class Labels implements Iterable<Label>{
    private final Label[] labels;

    public Labels(String[] names) {
        this.labels = Arrays.stream(names)
            .map(Label::new)
            .toArray(Label[]::new);
    }

    public int size() {
        return labels.length;
    }

    @Override
    public Iterator<Label> iterator() {
        return Arrays.stream(labels).iterator();
    }

    public int indexOf(Label label) {
        return Arrays.asList(labels).indexOf(label);
    }

    public Label at(int index) {
        return labels[index];
    }
}

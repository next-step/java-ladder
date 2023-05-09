package ladder.control.input;

import ladder.view.View;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public abstract class MultipleInput<T> extends InputControl<List<T>> {
    private static final String DELIMITER = ",";

    public MultipleInput(View view) {
        super(view);
    }

    @Override
    protected List<T> input() {
        String value = SCANNER.nextLine();
        return stream(value.split(DELIMITER))
                .map(String::trim)
                .map(this::parse)
                .collect(toList());
    }

    protected abstract T parse(String rawValue);
}

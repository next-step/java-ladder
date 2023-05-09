package ladder.control.input;

import ladder.model.Name;
import ladder.model.Names;
import ladder.view.View;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class NamesInput extends InputControl<Names> {
    private static final String DELIMITER = ",";

    public NamesInput(View view) {
        super(view);
    }

    @Override
    protected Names input() {
        String value = SCANNER.nextLine();
        List<Name> names = stream(value.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .collect(toList()
                );

        return new Names(names);
    }
}

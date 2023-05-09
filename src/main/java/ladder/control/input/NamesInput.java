package ladder.control.input;

import ladder.model.Name;
import ladder.view.View;

public class NamesInput extends MultipleInput<Name> {
    public NamesInput(View view) {
        super(view);
    }

    @Override
    protected Name parse(String rawValue) {
        return new Name(rawValue);
    }
}

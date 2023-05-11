package ladder.control.input.single;

import ladder.control.input.InputControl;
import ladder.model.participant.Name;
import ladder.view.View;

public class NameInput extends InputControl<Name> {
    public static Name ALL = new Name("all");

    public NameInput(View view) {
        super(view);
    }

    @Override
    protected Name input() {
        String input = SCANNER.nextLine().trim();
        return new Name(input);
    }
}

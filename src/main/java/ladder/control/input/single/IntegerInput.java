package ladder.control.input.single;

import ladder.control.input.InputControl;
import ladder.view.View;

public class IntegerInput extends InputControl<Integer> {

    public IntegerInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}

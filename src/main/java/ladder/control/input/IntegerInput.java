package ladder.control.input;

import ladder.view.View;

public class IntegerInput extends InputControl<Integer> {

    public IntegerInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        int value = Integer.parseInt(SCANNER.nextLine());
        return value;
    }
}

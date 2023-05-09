package ladder.control.input;

import ladder.view.View;

public class HeightInput extends InputControl<Integer> {

    public HeightInput(View view) {
        super(view);
    }

    @Override
    protected Integer input() {
        int value = Integer.parseInt(SCANNER.nextLine());
        return value;
    }
}

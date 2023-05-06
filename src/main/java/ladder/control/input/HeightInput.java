package ladder.control.input;

import ladder.view.View;

public class HeightInput extends InputControl<Height> {

    public HeightInput(View view) {
        super(view);
    }

    @Override
    protected Height input() {
        int value = Integer.parseInt(scanner.nextLine());
        return new Height(value);
    }
}

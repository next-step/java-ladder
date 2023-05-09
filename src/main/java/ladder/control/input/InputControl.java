package ladder.control.input;

import ladder.view.View;
import ladder.view.input.DummyView;

import java.util.Scanner;

public abstract class InputControl<T> {
    protected static final Scanner SCANNER = new Scanner(System.in);

    View view = new DummyView();

    public InputControl() {
    }

    public InputControl(View view) {
        this.view = view;
    }

    public T getValue() {
        view.render();
        return input();
    }

    protected abstract T input();
}

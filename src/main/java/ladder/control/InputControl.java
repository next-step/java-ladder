package ladder.control;

import ladder.view.DummyView;
import ladder.view.View;

import java.util.Scanner;

public abstract class InputControl<T> {
    protected static final Scanner scanner = new Scanner(System.in);

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

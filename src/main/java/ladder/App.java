package ladder;

import ladder.view.InputView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> names = InputView.inputPeople();
        int height = InputView.inputHeight();
    }
}

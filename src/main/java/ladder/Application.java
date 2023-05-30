package ladder;

import ladder.ui.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.saveInput();
        System.out.println(inputView.names);
    }

}

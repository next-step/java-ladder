package ladder;

import ladder.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String name = inputView.inputPlayerName();
        System.out.println(name);
    }
}

package ladder;

import ladder.ui.ConsoleInput;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> names = ConsoleInput.receiveNames();
        String height = ConsoleInput.receiveHeight();
    }
}

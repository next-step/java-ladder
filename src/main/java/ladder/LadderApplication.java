package ladder;

import ladder.controller.LadderController;

public class LadderApplication {
    private void run() {
        new LadderController().action();
    }
    
    public static void main(String[] args) {
        new LadderApplication().run();
    }
}

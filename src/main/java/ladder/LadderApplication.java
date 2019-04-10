package ladder;

import ladder.application.LadderService;
import ladder.console.LadderConsole;

public class LadderApplication {
    public static void main(String[] args) {
        LadderConsole.run(new LadderService());
    }
}

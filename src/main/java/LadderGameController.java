import domain.*;
import view.Input;
import view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {
    private final Input input;
    private final Output output;

    public LadderGameController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        List<String> nameInputs = input.readPlayerNames(); // 예: ["pobi", "honux", "crong"]
        List<PlayerName> playerNameList = nameInputs.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());
        PlayerNames playerNames = new PlayerNames(playerNameList);

        Results results = new Results(input.readResults());
        int height = input.readLadderHeight();

        Ladder ladder = LadderGenerator.generate(playerNames.size(), height);
        LadderGame game = new LadderGame(playerNames, results, ladder);

        output.printLadder(nameInputs, ladder, results.getValues());
        while (true) {
            String query = input.askPlayer();
            if (query.equalsIgnoreCase("all")) {
                output.printAllResult(game.playAll());
                break;
            }
            output.printResult(query, game.play(query));
        }
    }
}

package ladder.io;

import java.util.List;

public interface InputHandler {

    List<String> getNamesOfPlayersFromUser();

    List<String> getPlayResultsFromUser();

    int getHeightOfLadderFromUser();

    String getPlayerNameForResultFromUser();
}

package domain;

import view.ResultMapping;

import java.util.List;


public class LadderGameEngine {
    public static String move(Ladder ladder, int startIndex, List<PlayerName> players, ResultMapping mapping) {
        int position = startIndex;

        for (Line line : ladder.getLines()) {
            position = line.getNextPosition(position);
        }

        PlayerName resultPlayer = players.get(position);
        return mapping.getResult(resultPlayer);
    }
}
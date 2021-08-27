package nextstep.step4;

import nextstep.ladder.Ladder;
import nextstep.ladder.Player;
import nextstep.ladder.RandomLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.COMMON_ENTER;
import static nextstep.ladder.CommonConstans.NUMBER_ZERO;

public class LadderGame {

    private int numberOfPerson;
    private List<LadderLine> ladderLines;
    private List<Player> players = new ArrayList<>();

    public LadderGame(int numberOfPerson, List<LadderLine> ladderLines) {
        this.numberOfPerson = numberOfPerson;
        this.ladderLines = ladderLines;
    }

    public static LadderGame of(int numberOfPerson, List<LadderLine> ladderLines) {
        return new LadderGame(numberOfPerson, ladderLines);
    }

    public String drawLadderLines() {
        String laderLines = "";

        for (LadderLine ladderLine : ladderLines) {
            laderLines += ladderLine.drawLine() + COMMON_ENTER;
        }

        return laderLines;
    }

    public LadderResult playLadder() {
        LadderResult ladderResult = new LadderResult();

        for (int i = 0; i < numberOfPerson; i++) {
            ladderResult.put(i, getArrive(i));
        }

        return ladderResult;
    }

    private int getArrive(int position) {
        int arrivePosition = position;
        for (LadderLine ladderLine : ladderLines) {
            arrivePosition = ladderLine.move(arrivePosition);
        }
        return arrivePosition;
    }

    public void setPlayers(String[] players) {
        Arrays.stream(players).forEach(player -> this.players.add(Player.of(player)));
    }
    public int getPlayerIndex(String findPlayer) {
        int playerIndex = 0;

        for(Player player : players){
            if(player.getPlayer().equals(findPlayer)){
                playerIndex = players.indexOf(player);
            }
        }
        return playerIndex;
    }
}

package nextstep.ladder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class LadderGame {
    private List<Ladder> ladders = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Integer> lastPointPosition = new ArrayList<>();

    public LadderGame(String players, int ladderHeight) {
        setPlayers(players.trim().split(SEPARATOR_COMMA));
        setLadders(ladderHeight);
    }


    public static LadderGame of(String players, int ladderHeight) {
        return new LadderGame(players, ladderHeight);
    }

    private void setPlayers(String[] players) {
        Arrays.stream(players).forEach(player -> this.players.add(Player.of(player)));
    }

    private void setLadders(int ladderHeight) {
        IntStream.range(NUMBER_ZERO, ladderHeight)
                .forEach(row -> ladders.add(Ladder.of(players.size(), new RandomLine())));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Ladder> getladders() {
        return Collections.unmodifiableList(this.ladders);
    }

    public void checkPlayPointAndRow(int playerPoint, int row) {
        if (playerPoint >= players.size()) {
            throw new IllegalArgumentException("플레이어 시작포인트 범위에서 벗어났습니다.");
        }

        if (row > ladders.size()) {
            throw new IllegalArgumentException("사다리길이에서 벗어났습니다.");
        }

    }

    public int getResultPoint(int playerPoint, int row) {

        lastPointPosition.clear();
        checkPlayPointAndRow(playerPoint, row);

        lastPointPosition.add(ladders.get(NUMBER_ZERO).movePoint(playerPoint));

        IntStream.range(NUMBER_ONE, ladders.size())
                .forEach(index -> lastPointPosition.add(
                        ladders.get(index).movePoint(lastPointPosition.get(lastPointPosition.size() - NUMBER_ONE))));

        return lastPointPosition.get(lastPointPosition.size() - NUMBER_ONE);
    }

    public int findPlayerReward(String searchPlayer) {

        for (int index = 0; index < players.size(); index++) {
            if (players.get(index).getPlayer().equals(searchPlayer)) {
                return index;
            }
        }

        throw new IllegalArgumentException("검색하신 플레이어는 존재하지 않습니다.");
    }
}

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

    public LadderGame(String players) {
        setPlayers(players.trim().split(SEPARATOR_COMMA));
    }


    public static LadderGame of(String players) {
        return new LadderGame(players);
    }

    private void setPlayers(String[] players) {
        Arrays.stream(players).forEach(player -> this.players.add(Player.of(player)));
    }

    public void setLadders(int ladderHeight) {
        IntStream.range(NUMBER_ZERO, ladderHeight)
                .forEach(row -> ladders.add(Ladder.of(players.size(), new RandomLine())));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Ladder> getladders() {
        return Collections.unmodifiableList(this.ladders);
    }

    public void checkPlayPoint(int playerPoint) {

        if (playerPoint >= players.size()) {
            throw new IllegalArgumentException("플레이어 시작포인트 범위에서 벗어났습니다.");
        }
    }


    private int getResultPoint(int playerPoint) {

        List<Integer> lastPointPosition = new ArrayList<>();

        checkPlayPoint(playerPoint);

        for (int i = 0; i < ladders.size(); i++) {
            if (i == 0) {
                lastPointPosition.add(ladders.get(NUMBER_ZERO).movePoint(playerPoint));
                continue;
            }
            lastPointPosition.add(ladders.get(i).movePoint(lastPointPosition.get(lastPointPosition.size() - NUMBER_ONE)));
        }

        return lastPointPosition.get(lastPointPosition.size() - NUMBER_ONE);
    }

    private int findPlayerRewardIndex(String searchPlayer) {

        for (int index = 0; index < players.size(); index++) {
            if (players.get(index).getPlayer().equals(searchPlayer)) {
                return getResultPoint(index);
            }
        }

        throw new IllegalArgumentException("해당되는 Player가 없습니다.");
    }

    public String findPlayerReward(List<String> rewards, String searchPlayer) {

        return rewards.get(findPlayerRewardIndex(searchPlayer));

    }

}

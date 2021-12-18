package ladder.domain;


import java.util.Arrays;

public class Players {
    private final String[] players;

    public Players(String players) {
        if (isEmpty(players)) {
            throw new IllegalArgumentException("참여할 사람의 이름을 입력해주세요");
        }
        this.players = init(players);
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    private String[] init(String playersString) {
        String[] players = playersString.split(",");
        Arrays.stream(players).forEach((player) -> validate(player));
        return players;
    }

    private void validate(String player) {
        if (player.length() == 0 || player.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5자까지 가능합니다.");
        }
    }

    public String[] get() {
        return players;
    }

    public int countOfPlayers() {
        return players.length;
    }

}

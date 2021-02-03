package step2;

import java.util.*;

public class Players {

    private static final String SEPARATOR = ",";
    private static final String MINIMUM_PLAYER_MESSAGE = "참가자 리스트는 2명 이상 이어야 합니다.";
    private static final String NULL_PLAYER_MESSAGE = "참가자 리스트는 null일 수 없습니다.";
    public static final String BLANK = " ";
    public static final int MAX_NAME_LENGTH = 5;

    private List<Player> players =  new ArrayList<>();


    public Players(List<Player> players) {
        this.players = players;
    }

    private Players(String[] str) {
        if (str.length < 2) {
            throw new IllegalArgumentException(MINIMUM_PLAYER_MESSAGE);
        }

        Arrays.stream(str)
                .forEach(player -> players.add(Player.newPlayer(player)));
    }

    public static Players newPlayers(String str) {
        if (str == null) {
            throw new IllegalArgumentException(NULL_PLAYER_MESSAGE);
        }

        return new Players(str.trim().split(SEPARATOR));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            appendName(sb, player);
            appendBlankName(sb, player);
        }

        return sb.toString();
    }

    private static void appendName(StringBuilder sb, Player player) {
        String name = player.getName();
        sb.append(name);
    }

    private static void appendBlankName(StringBuilder sb, Player player) {
        int nameLength = MAX_NAME_LENGTH - player.getName().length();

        if (nameLength != 0) {
            for (int i = 0; i < nameLength; i++) {
                sb.append(BLANK);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
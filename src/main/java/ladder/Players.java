package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {

    private List<String> players;

    public Players(String playerString) {
        String[] playerArray = playerString.split(",");

        for (String name : playerArray) {
            isMoreCharacter(name);
        }

        players = Arrays.asList(playerArray);
    }

    private void isMoreCharacter(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("사람 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public void showPlayerNames() {
        players.stream().forEach(s -> System.out.print(s + "  "));
        System.out.println("");
    }

    public int getSize() {
        return players.size();
    }

}

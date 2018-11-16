package utils;

import domain.Player;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static final String NULL_CHAR = "\0";
    public static final String MID_BAR = "-";
    public static final String SPACE = " ";
    public static final String COMMA = ",";

    public static String[] splitDelemeter(String names){
        return names.split(COMMA);
    }

    public static List<Player> joinPlayer(String[] playerNames) {
        List<Player> players = new ArrayList<>();
        for(String playerName : playerNames){
            Player player =  new Player(playerName);
            players.add(player);
        }
        return players;
    }

    public static String getReplace(String character, int length) {
        return new String(new char[length]).replace(StringUtils.NULL_CHAR, character);
    }


}

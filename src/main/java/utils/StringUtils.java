package utils;

import domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static final String NULL_CHAR = "\0";
    public static final String MID_BAR = "-";
    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String ALL = "all";

    public static String[] splitDelemeter(String names) {
        return names.split(COMMA);
    }

    public static List<Player> joinPlayer(String[] playerNames) {
        return Arrays.stream(playerNames).map(x -> new Player(x)).collect(Collectors.toList());
    }

    public static String getReplace(String character, int length) {
        return new String(new char[length]).replace(StringUtils.NULL_CHAR, character);
    }


}

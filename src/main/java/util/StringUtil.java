package util;

import domain.NameTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String COMMA = ",";
    private static final String NULL_CHAR = "\0";
    public static final String MID_BAR = "-";
    public static final String SPACE = " ";

    private static String[] splitComma(String names) {
        return names.split(COMMA);
    }

    public static List<NameTag> makeNameTags(String names) {
        String[] nameTags = splitComma(names);
        List<NameTag> nameTagGroup = new ArrayList<>();
        Arrays.stream(nameTags).forEach(x -> nameTagGroup.add(NameTag.of(x)));

        return nameTagGroup;
    }


    public static String[] splitDelemeter(String names) {
        return names.split(COMMA);
    }

    public static List<NameTag> joinPlayer(String[] playerNames) {
        return Arrays.stream(playerNames).map(x -> NameTag.of(x)).collect(Collectors.toList());
    }

    public static String getReplace(String character, int length) {
        return new String(new char[length]).replace(StringUtil.NULL_CHAR, character);
    }
}

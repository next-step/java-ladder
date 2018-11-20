package utils;

import domain.NameTag;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static final String NULL_CHAR = "\0";
    public static final String MID_BAR = "-";
    public static final String SPACE = " ";
    public static final String COMMA = ",";

    private static String[] splitDelemeter(String names) {
        return names.split(COMMA);
    }

    public static List<NameTag> makeNameTag(String names) {
        String[] nameStr = splitDelemeter(names);
        List<NameTag> nameTags = new ArrayList<>();
        for (String name : nameStr) {
            NameTag nameTag = NameTag.of(name);
            nameTags.add(nameTag);
        }
        return nameTags;
    }

    public static String getReplace(String character, int length) {
        return new String(new char[length]).replace(StringUtils.NULL_CHAR, character);
    }


}

package ladder.util;

import ladder.domain.Participant;

import java.util.ArrayList;
import java.util.List;

public class LadderUtil {
    public static List<Participant> CastingArrayToList(String[] strings) {
        List<Participant> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(new Participant(removeSpace(strings[i])));
        }
        return list;
    }

    private static String removeSpace(String lottoString) {
        return lottoString.replaceAll("\\s", "");
    }
}

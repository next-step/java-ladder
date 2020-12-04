package nextstep.ladder.utils;

import java.util.List;

public class Lists {
    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }
}

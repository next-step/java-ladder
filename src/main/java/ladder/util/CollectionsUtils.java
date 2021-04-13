package ladder.util;

import java.util.List;

public class CollectionsUtils {

    public static <T> List<T> checkSize(List<T> list, int expectedSize) {
        if (list.size() != expectedSize) {
            throw new IllegalArgumentException("예상하는 크기와 같지 않습니다.");
        }
        return list;
    }

    public static <T> T[] checkSize(T[] arr, int expectedSize) {
        if (arr.length != expectedSize) {
            throw new IllegalArgumentException("예상하는 크기와 같지 않습니다.");
        }
        return arr;
    }
}

package nextstep.ladder.utils;

import java.util.List;
import java.util.Objects;

public class ObjectUtils {

    public static boolean isEmpty(List<?> objects) {
        return Objects.isNull(objects) || objects.isEmpty();
    }
}

package ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;

public class BarHelper {

    public static List<Bar> getBars(List<Boolean> availableData) {
        return availableData.stream()
                .map(BarHelper::getBar)
                .collect(Collectors.toList());
    }

    public static Bar getBar(boolean available) {
        return new Bar(available);
    }
}

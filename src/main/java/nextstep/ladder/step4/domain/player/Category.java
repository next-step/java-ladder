package nextstep.ladder.step4.domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Category {

    private final List<Name> category;

    private Category(List<Name> category) {
        this.category = category;
    }

    public static Category of(StringAsSplit stringAsSplit, int playerCount) {
        List<Name> category = Arrays.stream(stringAsSplit.split())
            .map(Name::new)
            .collect(Collectors.toCollection(ArrayList::new));

        valid(category.size(), playerCount);
        return new Category(category);
    }

    private static void valid(int size, int playerCount) {
        if (size != playerCount) {
            throw new IllegalArgumentException("플레이어 수와 결과 수는 같아야 합니다.");
        }
    }
}

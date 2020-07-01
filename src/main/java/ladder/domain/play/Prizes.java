package ladder.domain.play;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes extends Items {
    private Prizes(List<Prize> items) {
        super(items);
    }

    public static Prizes of(List<String> prizes) {
        List<Prize> items = prizes.stream()
                .map(Prize::of)
                .collect(Collectors.toList());

        return new Prizes(items);
    }

    public Prize get(int index) {
        return (Prize) super.items.get(index);
    }

    @Override
    void validateContains(String name) {
        if (!items.contains(Prize.of(name))) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }
}
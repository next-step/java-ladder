package nextstep.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Bonus의 일급컬렉션
 */
public class Bonuses {
    private List<Bonus> bonuses;

    public Bonuses(String input, int count) {
        List<Bonus> bonuses = splitAndTrim(input);
        if (count != bonuses.size()) {
            throw new IllegalArgumentException("보너스 개수와 사람 수가 일치하지 않습니다.");
        }
        this.bonuses = bonuses;
    }

    private List<Bonus> splitAndTrim(String input) {
        String[] names = input.split(",");
        return IntStream.range(0, names.length)
            .mapToObj(i -> Bonus.of(names[i].trim(), i))
            .collect(Collectors.toList());
    }

    public Optional<Bonus> getBonusByPosition(int index) {
        if (index < 0 || index >= bonuses.size()) {
            throw new IndexOutOfBoundsException("올바르지 않은 숫자입니다.");
        }
        return bonuses.stream()
            .filter(bonus -> bonus.isMatch(index))
            .findFirst();
    }

    public String getNameByPosition(int index) {
        return getBonusByPosition(index)
            .map(Bonus::getName)
            .orElseThrow(NoSuchElementException::new);
    }

    public List<Bonus> unmodifiableNames() {
        return Collections.unmodifiableList(bonuses);
    }
}

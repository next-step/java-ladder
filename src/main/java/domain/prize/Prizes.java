package domain.prize;

import domain.player.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prizes {

    private static final String NAME_SEPARATOR = ",";

    private static final String REMOVE_REGEX_OF_NAME = " ";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = Collections.unmodifiableList(prizes);
    }

    public static Prizes generate(String names) {
        List<Prize> prizes = Arrays.stream(split(replace(names)))
                .map(Prize::new)
                .collect(Collectors.toList());

        return new Prizes(prizes);
    }

    private static String[] split(String value) {
        return value.split(NAME_SEPARATOR);
    }

    private static String replace(String value) {
        return value.replaceAll(REMOVE_REGEX_OF_NAME, "");
    }

    public int size() {
        return this.prizes.size();
    }

    public Prizes filter(List<Integer> indexes) {
        return new Prizes(indexes.stream()
                .map(index -> this.prizes.get(index))
                .collect(Collectors.toList()));
    }

    public String beautify() {
        return IntStream.range(0, this.prizes.size())
                .mapToObj(i -> StringUtils.leftPad(beautify(i), Player.MAX_NAME_LENGTH))
                .collect(Collectors.joining(" "));
    }

    public String beautify(int index) {
        return this.prizes.get(index).beautify();
    }

    public String beautify(int index, String prefix) {
        return this.prizes.get(index).beautify(prefix);
    }

    // 필터링 결과 확인용
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    // 필터링 결과 확인용
    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}

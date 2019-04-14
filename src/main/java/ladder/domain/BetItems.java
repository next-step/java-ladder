package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetItems {
    private final List<BetItem> betItems;

    private BetItems(String words) {
        this.betItems = parse(words);
    }

    public static BetItems valueOfComma(String words) {
        return new BetItems(words);
    }

    private List<BetItem> parse(String words) {
        String[] names = words.split(",");
        return IntStream.range(0, names.length)
                .mapToObj(i -> new BetItem(i, names[i]))
                .collect(Collectors.toList());
    }

    public BetItem get(int i) {
        return betItems.get(i);
    }

    public int getCount() {
        return betItems.size();
    }

    public List<BetItem> getBetItems() {
        return betItems;
    }

    @Override
    public String toString() {
        return Name.BLANK + String.join(Name.BLANK,
                betItems.stream()
                        .map(BetItem::toString)
                        .collect(Collectors.toList()));
    }
}

package ladder.domain.play;

public class Prizes {
    private final Items prizes;

    private Prizes(Items prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(Items items) {
        return new Prizes(items);
    }

    public Item get(int index) {
        return prizes.get(index);
    }

    @Override
    public String toString() {
        return prizes.toString();
    }
}
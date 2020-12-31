package nextstep.laddergame.domain;

public class Index {
    private final int index;

     private Index(int index) {
        this.index = index;
    }

    public static Index from(int index) {
        return new Index(index);
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isEqualTo(int index) {
         return this.index == index;
    }
}

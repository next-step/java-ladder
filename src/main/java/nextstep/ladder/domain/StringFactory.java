package nextstep.ladder.domain;

public class StringFactory {

    private StringFactory() {
    }

    public static Name name(String name) {
        return new Name(name);
    }

    public static Item item(String item) {
        return new Item(item);
    }

}

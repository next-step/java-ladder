package ladder.domain;

public class RandomLinkSelector {
    static public Link link() {
        int selected = (int) Math.round(Math.random());
        return Link.values()[selected];
    }
}

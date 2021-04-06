package ladder.domain;

public class RandomLinkSelector implements LinkSelector {
    @Override
    public Link link() {
        int selected = (int) Math.round(Math.random());
        return Link.values()[selected];
    }
}

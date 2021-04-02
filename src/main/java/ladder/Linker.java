package ladder;

public class Linker {
    private final LinkSelector linkSelector;

    public Linker(LinkSelector linkSelector) {
        if (linkSelector == null) {
            linkSelector = () -> Link.OPEN;
        }

        this.linkSelector = linkSelector;
    }

    public Link link() {
        return linkSelector.link();
    }

    public Link link(Link previousLink) {
        if (previousLink == Link.CLOSE) {
            return Link.OPEN;
        }
        return linkSelector.link();
    }
}

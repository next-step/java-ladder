package ladder.domain;

public enum LadderLink {
    CONNECT,
    DIS_CONNECT;

    public static LadderLink of(LadderLink preLadderLink, LinkStrategy linkStrategy) {
        return preLadderLink == CONNECT ? DIS_CONNECT : randomCreate(linkStrategy);
    }

    private static LadderLink randomCreate(LinkStrategy linkStrategy) {
        return linkStrategy.isConnectable() ? CONNECT : DIS_CONNECT;
    }
}

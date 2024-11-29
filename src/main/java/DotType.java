public enum DotType {
    EMPTY,
    NODE,
    BRIDGE;

    public boolean is(DotType dotType) {
        return equals(dotType);
    }
}

public enum DotType {
    EMPTY,
    NODE,
    BRIDGE;

    public boolean is(DotType dotType) {
        return equals(dotType);
    }

    public static String print(DotType dotType) {
        String padding = "  ";

        if(dotType == EMPTY) { return "     "; }
        if(dotType == NODE) { return padding + "  |  "; }

        return "-----";
    }
}

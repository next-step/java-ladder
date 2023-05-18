package refactoring;

public enum LineStatus {
    CONNECTION, DETACHMENT;

    public static LineStatus of(boolean isConnected) {
        return isConnected ? CONNECTION : DETACHMENT;
    }
}

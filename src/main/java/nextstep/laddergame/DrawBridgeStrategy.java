package nextstep.laddergame;


import java.util.Random;

public class DrawBridgeStrategy {
    private final static Random random = new Random();
    public final static BridgeInterface DEFAULT_STRATEGY = () -> random.nextInt(10) < 5;
    public final static BridgeInterface DRAW_ALL = () -> true;
    public final static BridgeInterface DRAW_ANY = () -> false;
}

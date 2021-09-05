package nextstep.ladder;

import java.util.Map;

public class Game {
    private static final Game INSTANCE = new Game();
    
    private Map<String, Position> result;
    private Ladder ladder;
    
    public static Game getInstance() {
        return INSTANCE;
    }
    
    public void playGame(Ladder ladder){
        this.ladder = ladder;
        
    }
}

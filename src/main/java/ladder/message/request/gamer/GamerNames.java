package ladder.message.request.gamer;

import ladder.core.message.Request;

public class GamerNames implements Request {
    private final String gamerNames;
    
    public GamerNames(String gamerNames) {
        this.gamerNames = gamerNames;
    }
    
    public String getGamerNames() {
        return gamerNames;
    }
}

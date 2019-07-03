package ladder.message.gamer;

import ladder.core.message.Request;

public class GamerNamesDTO implements Request {
    private final String gamerNames;
    
    public GamerNamesDTO(String gamerNames) {
        this.gamerNames = gamerNames;
    }
    
    public String getGamerNames() {
        return gamerNames;
    }
}

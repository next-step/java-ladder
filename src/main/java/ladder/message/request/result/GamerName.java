package ladder.message.request.result;

import ladder.core.message.Request;

public class GamerName implements Request {
    private String gamerName;
    
    public GamerName(String gamerName) {
        this.gamerName = gamerName;
    }
    
    public String getGamerName() {
        return gamerName;
    }
    }

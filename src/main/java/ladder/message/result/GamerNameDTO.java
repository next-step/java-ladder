package ladder.message.result;

import ladder.core.message.Request;

public class GamerNameDTO implements Request {
    private String gamerName;
    
    public String getGamerName() {
        return gamerName;
    }
    
    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }
}

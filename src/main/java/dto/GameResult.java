package dto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameResult {

    private Map<Player,String> results = new HashMap<>();


    public GameResult() {
    }

    public GameResult(Map<Player, String> result) {
        this.results = result;
    }

    public void addResult(Player player ,String result){
        this.results.put(player,result);
    }

    public Map<Player,String> hasResult() {
        return this.results;
    }

    public String playersResult(Player player){
        return this.results.get(player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.results.keySet().iterator();
        while(it.hasNext()){
            Player temp = (Player)it.next();
            sb.append(temp.getName());
            sb.append(" : ");
            sb.append(this.results.get(temp)+"\n");
        }
        return sb.toString();
    }
}

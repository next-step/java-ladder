package domain;

import java.util.List;

public class PlayerGroup {
    List<Player> players;

    public PlayerGroup(List<Player> players) {
        if(players.stream().count() != players.stream().distinct().count()){
            throw new IllegalArgumentException("중복된 내용은 올 수 없습니다.");
        }
        this.players = players;
    }

    public int getNameIndex(String resultViewName) {
       if(players.stream().filter(x->x.toString().trim().equals(resultViewName)).count() < 1){
           throw new IllegalArgumentException("없는 이름입니다.");
       }
       return players.indexOf(new Player(resultViewName));
    }

    public String getName(int finalPosition) {
        return players.get(finalPosition).toString();
    }

    public int getSize(){
        return players.size();
    }
}

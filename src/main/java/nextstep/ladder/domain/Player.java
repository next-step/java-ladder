package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    private void validate(String name){
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름의 길이는 최대"+MAX_NAME_LENGTH+"글자 까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Player player = (Player) obj;
        return player.getName().equals(name);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }
}

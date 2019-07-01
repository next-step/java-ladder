package ladder.Model;

public class User {

    private String name;

    public User(String name) {
        this.name = nameException(name);
    }

    public String getName(){
        return this.name;
    }

    public int getNameLength(){
        return this.name.length();
    }

    private String nameException(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
        }
        return name;
    }

}

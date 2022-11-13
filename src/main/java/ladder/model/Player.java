package ladder.model;

import ladder.exception.WrongParameterException;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private int id;
    private String name;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;

        if (this.name.length() > MAX_NAME_LENGTH) {
            throw new WrongParameterException("[입력 오류] 플레이어의 이름은 최대 5자 입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}

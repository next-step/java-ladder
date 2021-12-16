package ladder.domain;

import ladder.exception.PlayerException;

public class Player {

    private static final int NAME_SIZE = 5;
    private static final int PRINT_SIZE = 6;
    private static final String ERR_NAME_SIZE = "이름은 최대 5글자 입니다.";
    private final String name;

    public Player(String name) {
        this.name = valid(name);
    }

    private String valid(String name) {
        if (name.length() > NAME_SIZE) {
            throw new PlayerException(ERR_NAME_SIZE);
        }
        return name;
    }

    public void print() {
        int emptySize = PRINT_SIZE - name.length();
        System.out.print(empty(emptySize) + name);
    }

    private String empty(int emptySize) {
        return new String(new char[emptySize]).replace('\0', ' ');
    }
}

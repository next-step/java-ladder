package nextstep.domain;

public enum CommandEnum {
    ALL("all");

    private final String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public boolean equals(String command) {
        return this.command.equals(command);
    }
}

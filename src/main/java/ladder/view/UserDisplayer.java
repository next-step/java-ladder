package ladder.view;

import java.util.function.Consumer;

import ladder.domain.Users;

public class UserDisplayer implements Displayer {
    private static final String BLANK = " ";
    
    private final Users users;
    private final int displaySize;
    
    public UserDisplayer(final Users users, final int displaySize) {
        this.users = users;
        this.displaySize = displaySize;
    }

    @Override
    public void show(Consumer<String> displayer) {
        displayer.accept(get());
    }
    
    String get() {
        StringBuilder display = new StringBuilder();
        for (String name : users.names()) {
            display.append(name);
            display.append(blank(name.length()));
        }
        return display.toString();
    }

    private String blank(int nameLength) {
        StringBuilder blank = new StringBuilder();
        blank.append(BLANK.repeat(Math.max(0, displaySize - nameLength + 1)));
        return blank.toString();
    }
}

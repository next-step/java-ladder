package ladder.view;

import java.util.List;

public class NamesDisplay {
    private static final String BLANK = " ";
    private final int displaySize;
    
    private final List<String> names;
    
    public NamesDisplay(final List<String> names, final int displaySize) {
        this.names = names;
        this.displaySize = displaySize;
    }

    public String get() {
        StringBuilder display = new StringBuilder();
        for (String name : names) {
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

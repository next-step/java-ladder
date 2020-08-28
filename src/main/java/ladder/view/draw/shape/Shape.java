package ladder.view.draw.shape;

@FunctionalInterface
public interface Shape {
	String HEIGHT_CONNECTION = "|";
	int WIDTH_LINE_COUNT = 5;
	String WIDTH_CONNECTION = "-";
	String WIDTH_WHITE_SPACE = " ";
	String NEW_LINE = "\n";


	String getShape();

}

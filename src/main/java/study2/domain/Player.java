package study2.domain;

public class Player {
	
	private String name;
	private static final String nameLimit = "이름은 최대 5글자 입니다.";
	private static final String leastNameLimit = "이름은 최소 1글자 이상, 공백은 불가능합니다.";
	
	private Player(String name) {
		nameLimiation(name);
	}

	private void nameLimiation(String name) {
		
		if(name.length() > 5) {
			throw new IllegalArgumentException(nameLimit);
		}
		
		if ("".equals(name) || " ".equals(name)) {
			throw new IllegalArgumentException(leastNameLimit);
		}
	}
}

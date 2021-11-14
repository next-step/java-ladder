package nextstep.optional;

import java.util.Objects;
import java.util.Optional;

public class User {
	private String name;
	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public boolean matchName(String name) {
		return this.name.equals(name);
	}

	public static boolean ageIsInRange1(User user) {
		boolean isInRange = false;

		if (user != null && user.getAge() != null
			&& (user.getAge() >= 30
			&& user.getAge() <= 45)) {
			isInRange = true;
		}
		return isInRange;
	}

	public static boolean ageIsInRange2(User user) {
		return Optional.ofNullable(user)
			.map(targetUser -> targetUser.age)
			.filter(age -> age >= 30 && age <= 45)
			.isPresent();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		User user = (User)obj;

		if (!Objects.equals(name, user.name)) {
			return false;
		}
		return Objects.equals(age, user.age);
	}
}

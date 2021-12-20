package utils;

import org.mindrot.jbcrypt.BCrypt;

public class Crypt {
	private static final int ROUNDS = 13;

	public static String hash(String contrasenia) {
		String salt = BCrypt.gensalt(ROUNDS);
		return BCrypt.hashpw(contrasenia, salt);
	}

	public static boolean match(String candidate, String hashed) {
		return BCrypt.checkpw(candidate, hashed);
	}
}

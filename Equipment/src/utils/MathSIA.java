package utils;

public class MathSIA {

	public static int sumTo(int n) {
		if (n == 0) {
			return 0;
		}
		return n + sumTo(n - 1);
	}
}

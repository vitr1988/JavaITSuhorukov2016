
public class Test {

	public static void main(String[] args) {
		System.out.println("Введите возраст");
		double a = 0;
		if (a < 25) {
			System.out.println("Молодой");
		} else {
			if (26 < a && a < 50) {
				System.out.println("Средний возраст");
			} else {
				if (51 < a && a < 60) {
					System.out.println("Пердпенсионный");
				} else {
					if (a > 60)
						System.out.println("пернсионер");
				}
			}
		}
	}
}
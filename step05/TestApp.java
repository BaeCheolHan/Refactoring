package step05;

public class TestApp {

	public static void main(String[] args) {
		Customer c = new Customer("john");
		Movie m = new Movie("어벤져스", Movie.NEW_RELEASE);
		Rental r = new Rental(m, 3);
		c.addRental(r);
		System.out.println(c.statement());
	}

}

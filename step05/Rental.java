package step05;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}
	// amountFor 메서드를 보면 Rental 클래스의 정보를 이용하고 정작 자신이 속한 Customer 클래스의 정보는 이용하지 않는다. 
	// 메서드는 대체로 자신이 사용하는 데이터와 같은 객체에 들어 있어야 한다. 그래서 amountFor 메서드를 Customer 클래스로 옮겨왔다. 이작업은 메서드 이동 기법을 실시하면 된다. 
	// 메서드를 옮겨오면서 메서드 명도 바꿨다. 매개변수를 삭제했다.
	public double getCharge() {
		double result = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULER:
			result += 2;
			if (getDaysRented() > 2)
				result += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (getDaysRented() > 3)
				result += (getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
		
	}
	
	public int getFrequentRenterPoints() {
		// 최신물을 이틀 이상 대여하면 2포인트를 지급하고 그 외엔 1포인트 지급하는 코드를 빼내
		// getFrequentRenterPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			return 2;
		else 
			return 1;
	}

}

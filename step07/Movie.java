package step07;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULER = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}
	public void setPriceCode(int arg) {
		_priceCode = arg;
	}
	public String getTitle() {
		return _title;
	}
	
	// 수정 코드가 제데로 돌아가게 하려고 대여 기간을 전달했다. 대여 기간은 Rental 클레서에 있는 데이터다. getCharge 메서드는 결국 두 개의 데이터인 대여 기간과
	// 비디오 종류를 사용한다. 대여기간을 Rental 클레스에 전달하지 않고 Movie 클래스에 전달했는데 왜그랬을까?
	// 그 이유는 사용자가 요청한 변경은 단지 새로운 비디오 종류를 추가해 달라는 것이었기 때문이다.
	// 대채로 비디오 종류에 대한 정보는 나중에 변경할 가성이 높다. 비디오 즁류를 변경해도 그로 인해 미치는 영향을 최소화 하고자 대여료 계산을 Movie 클래스 안에 넣은 것이다. 
	public double getCharge(int daysRented) {
		double result = 0;
		switch (getPriceCode()) {
		case Movie.REGULER:
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;
		}
		return result;

	}
	
	public int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else 
			return 1;
	}

}

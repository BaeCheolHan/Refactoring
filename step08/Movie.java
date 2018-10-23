package step08;

public class Movie {
	// 상속 구조 만들기 
	// Movie 클래스는 비디오 종류에 따라 같은 메서드 호출에도 각기 다른 값을 반환한다. 그런데 이건 하위클래스가 처리할 일이다.
	// 따라서 Movie 클래스를 상속받는 3개의 하위 클래스를 작성하고, 비디오 종류별 대여료 계산을 각 하위클래스에 넣어야 한다. 
	// 상태패턴 적용 했다.
	
	public static final int CHILDRENS = 2;
	public static final int REGULER = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;
	// 이제 priceCode가 새 클래스를 사용할 수 있게 Movie 클래스의 읽기/쓰기 메서드를 수정하자. 
	private Price _price;
	
	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}
	
	public int getPriceCode() {
		return _price.getPriceCode();
	}
	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULER:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("가격 코드가 잘못됬습니다.");
		}
	}
	public String getTitle() {
		return _title;
	}
	// 메서드 이동 기법을 실시해서 getCharge 메서드를 옮기자. (Price)
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	// getFrequenstRenterPoints 메서드를 Price 클래스로 옮기자. 
	public int getFrequentRenterPoints(int daysRented) {
			return _price.getFrequentRenterPoints(daysRented);
	}

}

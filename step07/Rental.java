package step07;

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
	// 사용자의 또다른 요구가 있다고 가정하자.
	// 대여점의 비디오 분류를 바꾸려고 준비중이다.
	// 분류를 어떻게 변경할지는 아직 결정하지 않았지만, 분명한 건 기존과 전혀 다른 방식으로 분류하리란 것이다. 수정하는 각 비디오 분류마다 대여료와 적립 포인트의 비율도 결정해야 한다.
	// 지금 이런식의 수정을하기엔 무리다. 우선, 대여료 메서드와 적립 포인트 메서드부터 마무리짓고 조건문 코드를 수정해서 비디오 분류를 변경해야 한다. 

	// 가격 책정 부분의 조건문을 재정의로 교체 
	
	// 타 객체의 속성을 swich 문의 인자로 하는 것은 나쁜 방법이다. swich문의 인자는 타 객체 데이터를 사용하지 말고 자신의 데이터를 사용해야 한다. 
	
	// getCharge() 메서드를 Movie 클래스로 옮기자 
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	// getCharge 메서드를 옮겼으면 적립 포인트 계산 메서드도 마찬가지로 옮기자.
	// 이렇게 하면 비디오 종류마다 달라지는 대여료와 적립 포인트 계산이 비디오 분류가 든 클래스 자체에서 처리된다. 
	public int getFrequentRenterPoints() {
			return _movie.getFrequentRenterPoints(_daysRented);
	}

}

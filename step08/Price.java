package step08;

public abstract class Price {
	abstract int getPriceCode();
	
	// getCharge 메서드를 옮겼으면 조건문을 재정으로 전환 기법을 실시 
	// Price를 상속받는 모든 메서드의 getCharge() 메서드의 case 문을 재정의 메서드로 만들었으면 Price.getCharge() 메서드를 추상 메서드로 선언하자.
	abstract double getCharge(int daysRented); 
	
	// 이때 상위 클래스 메서드를 추상메서드로 만들지 말고 그 대신 NewReleasePrie 클래스에 재정의 메서드를 작성하자. 
	public int getFrequentRenterPoints(int daysRented) {
			return 1;
	}

}

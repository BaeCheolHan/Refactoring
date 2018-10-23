package step04;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		_name = name;
	}
	public void addRental(Rental arg ) {
		_rentals.addElement(arg);
	}
	public String getName() {
		return _name;
	}
	//statement 메서드 분해와 기능 재분배 
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = getName() + " 고객님의 대여 기록\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			
			//비디오 종류별 대여료 계산 함수를 호출 
			// thisAmount 변수는 each.getCharge() 메서드의 결과를 저장하는데만 사용되고 그 후엔 전혀 사용되지 않는다. 따라서 임시변수를 메서드호출로 전환 기법을 사용하여
			// thisAmount 변수를 삭제해야 한다.
			// 이런 임시변수는 최대한 없애는 것이 좋다. 임시 변수가 많으변 불필요하게 많은 매개변수를 절달하게 되는 문제가 흔히 생긴다. 심지어 임시변수의 용도를 차츰 잊기 십상이다.
			// 임시 변수는 특히 긴 메서드 안에서 알게 모르게 늘어나는데, 당연히 성능이 떨어진다. 
			
			//적립 포인트를 1 포인트 증가
			frequentRenterPoints ++;
			//최신물을 이틀 이상 대여하면 보너스 포인트 지급 
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints ++;
			
			// 이번에 대여하는 비디오 정보와 대여료를 출력 
			result += "\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(each.getCharge()) + "\n";
			//현재까지 누적된 총 대여료 
			totalAmount += each.getCharge();
		}
		//푸터행 추가
		result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
		result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
		return result;
				
	}
	
}

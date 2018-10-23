package step06;

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
		// 임시 변수를 메서드 호출로 전환 기법을 실시해서 totalAmount 변수와 frequentRentalPoints 변수를 질의 메서드로 고친다.
		// 질의 메서드는 클래스안의 모든 메서드에서 접근 가능하므로 메서드를 복잡하게 만드는 이런 임시변수를 사용하지 않아도 되니 설계가 한결 깔끔해진다. 

		// 이 프로그램의 사용자가 대여 내역을 웹에서도 볼 수 있고 다른 대중적 형식과도 호환 되게끔 HTML로 출력되길 원한다고 가정하자. 
		// htmlStatement메서드를 생성할 것이다.
		// 계산 부분을 빼내서 htmlStatement 메서드로 작성하면 처음의 statement 메서드에 들어있던 계산 코드를 전부 재사용할 수 있다.
		// 복사해서 붙인 중복 코드가 없으니 계산식 자체를 수정해야 할 때도 한군데만 수정하면 된다.
		// 이제 어떠한 형식의 내역이든 아주 신속하고 간편히 준비할 수 있다.
		// 헤더, 푸터, 세부항목 행을 처리하는 코드를 빼내서 각각 메서드로 작성하는 방법도 있다.
		// 이 방법은 템플릿 메서드 형성 기법 절에 있는 예제를 참조하자.
		Enumeration rentals = _rentals.elements();
		String result = getName() + " 고객님의 대여 기록\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			// 이번에 대여하는 비디오 정보와 대여료를 출력 
			result += "\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(each.getCharge()) + "\n";
		}
		//푸터행 추가
		result += "누적 대여료: " + String.valueOf(getTotalCharge()) + "\n";
		result += "적립 포인트: " + String.valueOf(getTotalFrequentRenterPoints());
		return result;

	}

	public String htmlStatement() {
		Enumeration rentals = _rentals.elements();
		String result = "<H1><EM>" + getName() + " 고객님의 대여 기록</EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// 모든 대여 비디오 정보와 대여료를 출력 
			result += "\t" + each.getMovie().getTitle() + ": " +
					String.valueOf(each.getCharge()) + "<BR>\n";
		}
		//푸터행 추가
		result += "<P>누적 대여료: <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "적립 포인트: <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM><P>";
		return result;

	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}

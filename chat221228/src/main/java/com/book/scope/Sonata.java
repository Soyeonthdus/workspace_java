package com.book.scope;

public class Sonata {
	int speed = 10;
	public String carName = "2023년형 소나타";
	int wheelNum = 4;
	
	//생성자
	public Sonata() {
		//10, 2023년형 소나타, 4
		System.out.println("디폴트 생성자 - 파라미터가 없는 생성자");
	}
	public Sonata(int speed, String carName) {
		//파라미터값, 파라미터값, 4
		this.speed=speed;
		this.carName = carName;
	}
	public Sonata(int speed, String carName, int wheelNum) {
		//파라미터값, 파라미터값, 파라미터값
		this.speed=speed;
		this.carName = carName;
		this.wheelNum = wheelNum;
	}
	

}//end of class

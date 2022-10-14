package runner.inheritance;

import beginner.methods.inheritance.Car;
import beginner.methods.inheritance.SCross;
import beginner.methods.inheritance.Swift;
import beginner.methods.inheritance.XUV;

public class InheritanceRunner {
	static Car carObj = new Car();
	static Swift swiftObj = new Swift();
	static XUV XUVObj = new XUV();
	static SCross SCrossObj = new SCross();

	public void experiment2() {
		System.out.println("Experiment 2 :\n");
		swiftObj.setSeats(4);
		swiftObj.setAirbags(2);
		swiftObj.setModel("S4");
		swiftObj.setColor("RED");
		System.out.println("No of seats : " + swiftObj.getSeats());
		System.out.println("No of airbags : " + swiftObj.getAirbags());
		System.out.println("Swift Model : " + swiftObj.getModel());
		System.out.println("Car color : " + swiftObj.getColor());
	}

	public void experiment3() {
		System.out.println("Experiment 3 :\n");
		SCrossObj.setType("Sedan");
		SCrossObj.setYearOfMake(2019);
		SCrossObj.setEngineNumber("Kkd3368");
		SCrossObj.setSeats(6);
		SCrossObj.setAirbags(3);
		SCrossObj.setModel("Xtend500");
		SCrossObj.setColor("BLUE");
		System.out.println("Car type : " + SCrossObj.getType());
		System.out.println("Year of make : " + SCrossObj.getYearOfMake());
		System.out.println("Engine Number : " + SCrossObj.getEngineNumber());
		System.out.println("No of seats : " + SCrossObj.getSeats());
		System.out.println("No of airbags : " + SCrossObj.getAirbags());
		System.out.println("Swift Model : " + SCrossObj.getModel());
		System.out.println("Car color : " + SCrossObj.getColor());
	}

	public void experiment4_5(Car testObj) {
		if (testObj instanceof Swift) {
			testObj.setType("Hatch");
			System.out.println(testObj.getType());
		}
		else if (testObj instanceof XUV) {
			testObj.setType("SUV");
			System.out.println(testObj.getType());
		} 
		else if (testObj instanceof SCross) {
			testObj.setType("Sedan");
			System.out.println(testObj.getType());
		}
	}

	public void experiment6(Swift testObj) {
		testObj.setType("Hatch");
		System.out.println(testObj.getType());
		testObj.setColor("Swift RED");
		System.out.println(testObj.getColor());
	}

	public static void main(String[] args) {
		
//		InheritanceRunner testerObj = new InheritanceRunner();
		
//		testerObj.experiment2();
		
//		testerObj.experiment3();
		
//		testerObj.experiment4_5(swiftObj);
		
//		testerObj.experiment6(swiftObj);
		
		// experiment 7
//		SCrossObj.maintenance();	//calls SCross maintenance
//		Car obj1 = new SCross();
//		obj1.maintenance();			//calls SCross maintenance
//		Car obj2 = new Car();
//		obj2.maintenance();			//calls Car maintenance
//		Swift obj3 = new Swift();
//		obj3.maintenance();			//calls Car maintenance
		
		// experiment 8
//		XUV obj1 = new XUV();
//		XUV obj2 = new XUV("Overloaded Constructor");
		
		// experiment 9
//		BirdAbstract obj1 = new BirdAbstract();
//		obj1.fly();
//		obj1.speak();
//		ParrotMod obj2 = new ParrotMod();
//		obj2.fly();
//		obj2.speak();
		
		// experiment 10
//		Duck obj1 = new Duck();
//		obj1.fly();
//		obj1.speak();
		
	}
}

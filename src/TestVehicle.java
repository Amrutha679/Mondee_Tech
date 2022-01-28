import java.util.*;

interface Vehicle{
	
	void speed();
}

abstract class Car implements Vehicle{
	
	abstract void steering();
	public void speed() {
		System.out.println("Average speed of Car 80km/h");
	}
}

abstract class Bike implements Vehicle{
	
	abstract void helmet();
	
	public void speed() {
		System.out.println("Average speed of Bike 12mph");
	}
}
class Audi extends Car{
	public void steering() {
		System.out.println("Providing steering cover");
	}
	public void mileage() {
		System.out.println("Audi car mileage is 30kmpl");
	}
}
class Kia extends Car{
	public void steering() {
		System.out.println("Not providing steering cover");
	}
	public void mileage() {
		System.out.println("Kia car mileage is 28kmpl");
	}
}
class Honda extends Bike implements Vehicle{
	public void helmet() {
		System.out.println("Providing helmet");
	}
	public void speed() {
		System.out.println("Honda bike speed is 23km/h");
	}
}
class Suzuki extends Bike implements Vehicle{
	
	public void helmet() {
		System.out.println("Not Providing helmet");
	}
	public void speed() {
		System.out.println("Suzuki bike speed is 20km/h");
	}
}

public class TestVehicle {
	public static void main(String args[]) {
		Car obj = new Audi();
		
		obj.steering();
		obj.speed();
		((Audi) obj).mileage();
		
		obj = new Kia();
		obj.steering();
		((Kia) obj).mileage();
		
		Bike obj2 = new Honda();
		obj2.helmet();
		obj2.speed();
		
		obj2 = new Suzuki();
		obj2.helmet();
		obj2.speed();
		
	}
}
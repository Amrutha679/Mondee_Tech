import java.util.*;

abstract class Animal{
	
	abstract void lifeTime();
	
	public void breath() {
		System.out.println("Animal breaths oxygen");
	}
}
class Dog extends Animal{
	
	void lifeTime() {
		System.out.println("Dog life time is 10 - 13years");
	}
}
class Lion extends Animal{
	void lifeTime() {
		System.out.println("Lion life time is 10 - 15years");
	}
}
class GetAnimal{
	public Animal getLifeTime(String animalType) {
		if(animalType == null) {
			return null;
		}
		if(animalType.equalsIgnoreCase("DOG")) {
			return new Dog();
		}
		else if(animalType.equalsIgnoreCase("LION")) {
			return new Lion();
		}
		return null;
	}
}
public class TestFactory {

	public static void main(String[] args) {
		
		GetAnimal obj = new GetAnimal();
		   
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Animal Name");
		String animalName = sc.nextLine();
		  
		Animal a = obj.getLifeTime(animalName);  
		a.breath();
		a.lifeTime();
		
	}

}



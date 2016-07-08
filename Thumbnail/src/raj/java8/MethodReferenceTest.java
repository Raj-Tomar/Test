package raj.java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		list.forEach(System.out :: println);
	}

}

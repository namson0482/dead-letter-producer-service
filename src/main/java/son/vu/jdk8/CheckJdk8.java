package son.vu.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CheckJdk8 {

	public static void check(String... args) {
		if(args.length == 0) return;
				
//		for(String value: args) {
//			System.out.println(value);
//		}
		
		List<String> list = Arrays.asList(args);
		list.forEach(x -> {
			try {
				int value = Integer.parseInt(x);
				System.out.println(value + " is integer");
			} catch (Exception e) {
				System.out.println("Value is not integer");
			}
		});
	}
	
	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s + " Khanh");
		Consumer<String> c2 = s -> System.out.println(s + " Huong Dan Java");
 
		c1.andThen(c2).accept("Hello");
	}
}

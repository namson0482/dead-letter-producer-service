package son.vu.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 
public class StreamExample {
 
    List<Integer> numbers = Arrays.asList(3, 4, 5, 7);
 
    public void withoutStream() {
        long count = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        System.out.printf("There are %d elements that are even", count);
        System.out.print("\n");
    }
 
    public void withStream() {
        long count = numbers.parallelStream().filter(num -> num > 3).count();
        System.out.printf("There are %d elements that are even", count);
    }
 
    public static void main(String[] args) {
    	
//    	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        Integer maxx = list.stream().max((o1, o2) -> {
//        	return o1.compareTo(o2);
//        }).get();
//        Integer minn = list.stream().min(Integer::compare).get();
//        System.out.println("Max: "+maxx+"\nMin: "+minn);
        
        
        List<Integer> listTemp = Arrays.asList(30,32,10,10,10,11,12,23,13,11,9,8, 1,2,2,2,2,3,4,10,9,5);
        List<Integer> result = listTemp.stream().distinct().sorted(Integer::compare).collect(Collectors.toList());
        final String []arrayString = new String[1];
        arrayString[0] = "";
        result.stream().forEach(x -> arrayString[0] += x + ", ");
        if(arrayString[0].length() > 0)
        	System.out.println(arrayString[0].subSequence(0, arrayString[0].length() - 2));
	}
}

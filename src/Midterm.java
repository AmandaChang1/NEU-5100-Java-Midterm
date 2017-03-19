import java.util.*;
public class Midterm {
	
	//1
	public static <E> void reverse(ArrayList<E> list){
		for (int j=0; j<list.size()/2; j++){
			E c = list.get(j);
			list.set(j, list.get(list.size()-j-1));
			list.set(list.size()-j-1, c);
		}
		System.out.println(list);
		
	}
	
	
	//2
	public static String generateStrings (String s1, String s2){
		StringBuilder b = new StringBuilder();
		Set<Character> one = new HashSet<>();
		for (int i=0; i<s1.length();i++){
			char c = s1.charAt(i);
			if (one.contains(c)){
				continue;
			}
			one.add(c);
			
			Set<Character> two = new HashSet<>();
			
			for (int j=0; j<s2.length();j++){
				char ch = s2.charAt(j);
				if(two.contains(ch)){
					continue;
				}
				
				two.add(ch);
				b.append(" ").append(c).append(ch);
			
				
			}
		}
		return b.substring(1);
		
	}
	
	//3
	public static int singleNumber(int[] nums){
		Set<Integer> arr = new HashSet<Integer>(); 
		for (int i : nums){
			if (!arr.remove(i)){
				arr.add(i);
			}
		}
		assert arr.size() == 1;
		
		return arr.iterator().next();
	
	}
	
	//4
	public int[] twoSum(int[] nums, int target){
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++)
			map.put(nums[i], target-nums[i]);
		
		for(int j=0; j<nums.length; j++)
			if(map.containsValue(nums[j]) && map.get(nums[j]) != null){
				 System.out.println("("+nums[j]+","+map.get(nums[j])+")");
	                map.remove(nums[j]);
			}
		
		return nums;
		
	}
	
	
	//5
	public List<Integer> getRom(int rowIndex){
		if (rowIndex == 1){
	          List <Integer> list = new ArrayList(rowIndex+1);
	          list.add(1);
	          return list;
	      }
	        else{
	              List<Integer> oldList = getRom(rowIndex -1);
	              List <Integer> list = new ArrayList(rowIndex+1);
	              int temp = 0;
	              list.add(0,1);
	              list.add(list.size()-1,1);
	             
	              for (int i = 1; i < list.size()-1; i ++){
	                 temp = oldList.get(i) + oldList.get(i-1);
	                 list.add(i,temp);
	              }
	              return list;

	        }
		
	}
	
	public static void main(String[] args) {
		Midterm m = new Midterm();
		//1
		ArrayList list = new ArrayList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		m.reverse(list);
		
		//2
		String s1="ACDC";
		String s2="ABBA";
		System.out.println(m.generateStrings(s1, s2));
		
		//3
		int [] nums = {2,2,5,5,6};
		System.out.println(m.singleNumber(nums));
		
		//4
		int [] num = {2,7,11,15};
		int target = 9;
		System.out.print(m.twoSum(num, target));
		
		//5
		System.out.println(m.getRom(3));
		

	}

}

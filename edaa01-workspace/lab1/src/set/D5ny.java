package set;



public class D5ny {
	
	
	public static void main(String[] args) {
		int[] vector = {1, 2, 4, 3, 3, 1};
		int[] sorterad = uniqueElements(vector);
		for (int i = 0; i < sorterad.length; i++){
			System.out.print(sorterad[i]);
			
		}
	}
	
	
	public static int[] uniqueElements(int[] ints){
		MaxSet<Integer> newSet = new MaxSet<Integer>();
		for (int i = 0; i < ints.length; i++){
			newSet.add(ints[i]);
		}
		int[] inOrder = new int[newSet.size()];
		int k = newSet.size();
		int i = 1;
		while(newSet.size() > 0){
			inOrder[k-i] = newSet.getMax();
			newSet.remove(newSet.getMax());
			i++;
			}	
		
		return inOrder;
	}
	

}

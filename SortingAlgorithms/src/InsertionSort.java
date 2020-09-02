



public class InsertionSort {

	public static void sortByInsert(char[] a) {
		
		for(int i=1; i<a.length; i++) {
			int j = i-1;
			char cur = a[i];
			
			while((j>=0) && (a[j] > cur)) {
				a[j+1] = a[j--];
			}
			
			a[j+1] = cur;	
		}
	}
	public static void main(String[] args) {
		char[] name = {'c','a','g','a','t','a','y'};
		
		System.out.println(name);
		sortByInsert(name);
		System.out.println("after sorting---");
		System.out.println(name);
	}
}

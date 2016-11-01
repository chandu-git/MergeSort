package mergeSort;

public class MergeSort {

	/**
	 * Divide an unsorted list into sublists that all contain 1 element, 
	 * and then by repeatedly merging these sublists until there is only 1 
	 * sorted list remaining
	 */
	public static int[] mergeSort(int[] A, int p, int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p,q,r);
		}
		return A;
	}
	
	public static void merge(int[] A, int p, int q, int r){
		int n1 = q-p+1; int n2=r-q;
		int[] L = new int[n1+1];int[] R = new int[n2+1];
		for(int i=0;i<n1;i++){
			L[i]=A[p+i-1];
		}
		for(int i=0;i<n2;i++){
			R[i] = A[q+i];
		}
		L[n1]=Integer.MAX_VALUE;R[n2]=Integer.MAX_VALUE;
		int i=0;int j=0;
		for(int k=p-1;k<r;k++){
			if(L[i]<=R[j]){
				A[k]=L[i++];
			}else{
				A[k]=R[j++];
			}
			
		}
	}
	
	public static void mergeWOSentinels(int[] A, int p, int q, int r){
		int n1 = q-p+1; int n2=r-q;
		int[] L = new int[n1];int[] R = new int[n2];
		for(int i=0;i<n1;i++){
			L[i]=A[p+i-1];
		}
		for(int i=0;i<n2;i++){
			R[i] = A[q+i];
		}
		//L[n1]=Integer.MAX_VALUE;R[n2]=Integer.MAX_VALUE;
		int i=0;int j=0;
		for(int k=p-1;k<r;k++){
			if (i == n1) {
	            A[k] = R[j++];
	        } else if (j == n2) {
	            A[k] = L[i++];
	        } else if(L[i]<=R[j]){
				A[k]=L[i];
				i=i+1;
			}else{
				A[k]=R[j];
				j=j+1;
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] A = {60,40,20,50,80,30,10,90};
		long startTime = System.currentTimeMillis();
		A = mergeSort(A, 1, A.length);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
		for(int i=0;i<A.length;i++){
			System.out.println(A[i]);
		}
 	}
}

package sorting;
//import java.util.*;

public class Sorting {
	
	
	public int[] arr = new int[10];{
	   int length1=arr.length;
	for(int i=0;i<length1;i++){
		arr[i]=  (int) (Math.random()*6)+1;
	}
	System.out.println("Array elements");
	for(int i1=0;i1<length1;i1++){
    System.out.println(" " + arr[i1]);
	}

	}
	public void bubbleSort(){
		int length1=arr.length;
		for(int i=0;i<length1-1;i++){
            for(int j=0;j<length1-i-1;j++){
            	if(arr[j]>arr[j+1]){
            		int temp = arr[j];
            		arr[j]=arr[j+1];
            		arr[j+1]= temp;
            	}
            }
            
		}
		System.out.println("bubble sorted array");
        for(int k=0;k<length1;k++){
        System.out.println(" "+arr[k]);	
        }
        
        }	
	public void selectionSort(){
		int length1=arr.length;
		for(int i=0;i<length1;i++){
			int pos=i;
			for(int j=i+1;j<length1;j++){
				if(arr[j]<arr[pos])
					
					pos=j;
				}
				if(pos != i){
					int temp = arr[i];
					arr[i]=arr[pos];
					arr[pos]=temp;
				}
			
		}
			System.out.println(" selection sorted array");
	        for(int k=0;k<length1;k++){
	        System.out.println(" "+arr[k]);	
	        }
		
	
    
	}
	public void insertionSort(){
		
	int n = arr.length;
    for (int j = 1; j < n; j++) {
        int key = arr[j];
        int i = j-1;
        while ( (i > -1) && ( arr [i] > key ) ) {
            arr [i+1] = arr [i];
            i--;
        }
    
        arr[i+1] = key;
       // printNumbers(array);
        
	
    } 
    System.out.println(" insertion sorted array");
    for(int k=0;k<n;k++){
    System.out.println(" "+arr[k]);	
    }
    
      }
	public void quickSort(){
		int n = arr.length;
		quicksort1(0,n-1);
		System.out.println(" quick sorted array");
        for(int k=0;k<n;k++){
        System.out.println(" "+arr[k]);	
        }
	}
	public void quicksort1(int low,int high){
		int i=low , j=high;
		int length1=arr.length;
		int pivot= arr[low+(high-low)/2];
		
		while(i<=j){
			
			while(arr[i]< pivot){
				i++;
			}
			
			while(arr[j]>pivot){
				j--;
			}
			
			if(i<=j){
				int temp = arr[i];
				   arr[i]= arr[j];
				   arr[j]= temp;
				   i++;
				   j--;
			}
			}
	     if(low<j)
	    	 quicksort1(low,j);
	     if(i<high)
	    	 quicksort1(i,high);
	     
	     
	    	 
	     }
		}
	
	

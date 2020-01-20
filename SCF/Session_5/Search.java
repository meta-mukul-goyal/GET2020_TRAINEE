package scf_5;

public class Search {
	
	/**
	 * find index of the search key
	 * @param arr as a array of int type
	 * @param key as a search value of int type
	 * @param i as a starting index
	 * @return i if key value is found in array
	 * @return -1 if key is not found
	 */
	public int linearSearch(int[] arr, int key, int i){
		if ( arr[i] == key )
			return i;
		if ( i == arr.length -1 )
			return -1;
		return linearSearch(arr, key, ++i);
	}
	
	/**
	 * find index of the search key
	 * @param arr as a array of int type
	 * @param key as a search value of int type
	 * @param beg as a starting index of array
	 * @param end as a len or last index of array
	 * @return i if key value is found in array
	 * @return -1 if key is not found
	 */
	public int binarySearch(int[] arr, int key, int beg, int end){
		int mid = (beg+end)/2;
		if ( arr[mid] == key)
			return mid;
		if ( beg < end )
			if ( arr[mid] > key )
				return  binarySearch(arr, key, beg, mid-1);
			else
				return binarySearch(arr, key, mid+1, end);
		return -1;
	}
	
//	public static void main(String[] arsg){
//		Search obj = new Search();
//		int[] arr={1,2,3,4};
//		System.out.println(obj.binarySearch(arr, 4, 0, 3));
//	}

}

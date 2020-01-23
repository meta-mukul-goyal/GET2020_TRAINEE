package scf8;

public class SparseMatrix {
	private final int sparse[][];
	private int numNonZero;
	private int rowLen;
	private int colLen;
	
	SparseMatrix(int[][] intializingArray){
		if ( intializingArray.length == 0)
			throw new AssertionError();
		if ( !checkSparseValid(intializingArray)){
			throw new AssertionError();
		}
		this.sparse = createSpare(intializingArray);
	}
	
	private int[][] createSpare(int[][] arr) {
		int sparseMatrix[][] = new int[this.numNonZero][3], k=0;
		for ( int i=0; i<this.rowLen; i++ )
			for ( int j=0; j<this.colLen; j++ )
				if ( arr[i][j] != 0 ){
					sparseMatrix[k][0] = i;
					sparseMatrix[k][1] = j;
					sparseMatrix[k][2] = arr[i][j];
					k++;
				}
		return sparseMatrix;
	}

	private boolean checkSparseValid(int[][] arr) {
		this.rowLen = arr.length; int countZero=0;
		this.colLen = arr[0].length;
		for ( int i=0; i<rowLen; i++ )
			for ( int j=0; j<colLen; j++ )
				if ( arr[i][j] == 0 )
					countZero++;
		this.numNonZero = rowLen*colLen-countZero;
		if ( countZero < this.numNonZero)
			return false;
		return true;
	}
	
	public int[][] transpose(){
		int rowLen = this.sparse.length;
		int tranposeMatrix[][] = new int[rowLen][3];
		for ( int i=0; i<rowLen; i++ ){
			tranposeMatrix[i][1] = this.sparse[i][0];
			tranposeMatrix[i][0] = this.sparse[i][1];
			tranposeMatrix[i][2] = this.sparse[i][2];
		}
		return tranposeMatrix;
	}
	
	public boolean symmetric(){
		int rowValue, colValue, value, j;
		int rowLen = this.sparse.length;
		if ( !(this.rowLen == this.colLen) )
			throw new AssertionError();
		
		for ( int i=0; i<rowLen; i++ ){
			rowValue = this.sparse[i][0];
			colValue = this.sparse[i][1];
			if ( rowValue == colValue )
				continue;
			value = this.sparse[i][2];
			for ( j=0; j<rowLen; j++ )
				if ( rowValue==this.sparse[j][1] && colValue==this.sparse[j][0] && value==this.sparse[j][2])
					break;
			if ( j == rowLen)
				return false;
		}
		return true;
	}
	
	public int[][] additionSparse(SparseMatrix obj1){
		if(rowLen!=obj1.rowLen && colLen!=obj1.colLen)
			throw new AssertionError();
		int rowLen1 = sparse.length, rowLen2 = obj1.sparse.length, k=0, j, i;
		int addMatrix[][] = new int[rowLen1+rowLen2][3];
		for(i=0 ; i<rowLen1 ; i++){	
			for(j=0 ; j<rowLen2 ; j++)
				if(sparse[i][0]==obj1.sparse[j][0] && sparse[i][1]==obj1.sparse[j][1]){
					addMatrix[k][0]=sparse[i][0]; addMatrix[k][1]=sparse[i][1];
					addMatrix[k][2]=sparse[i][2] + obj1.sparse[j][2];
					k++;break;
					}
			if ( j == rowLen2 ){
				addMatrix[k][0]=sparse[i][0]; addMatrix[k][1]=sparse[i][1]; addMatrix[k][2]=sparse[i][2];
				k++;
			}
		}
		for(j=0 ; j<rowLen2 ; j++){
			for(i=0 ; i<rowLen1 ; i++)
				if(sparse[i][0]==obj1.sparse[j][0] && sparse[i][1]==obj1.sparse[j][1])
					break;
			if ( i == rowLen1 ){
				addMatrix[k][0]=obj1.sparse[j][0]; addMatrix[k][1]=obj1.sparse[j][1]; addMatrix[k][2]=obj1.sparse[j][2];
				k++;
			}
		}		
		return addMatrix;
	}
	
	public  int[][] multiplySparse(SparseMatrix obj1, SparseMatrix obj2) throws AssertionError{
		int rowLen1 = obj1.rowLen, rowLen2 = obj2.rowLen, colLen1 = obj1.colLen;
		if(colLen1 != rowLen2)
			throw new AssertionError("Mismatch in dimensions of col*row of matrices.");

		int[][] newMatrix = new int[rowLen1][colLen1];

		for ( int i =0; i<obj1.sparse.length; i++ ){
			for ( int j=0; j<obj2.sparse.length; j++ ){
				if(obj1.sparse[i][1] == obj2.sparse[j][0])
					newMatrix[obj1.sparse[i][0]][obj2.sparse[j][1]] += obj1.sparse[i][2] * obj2.sparse[j][2];
			}
		}
		return newMatrix;
	}
	
	public int[][] getSparse() {
		return this.sparse.clone();
	}
	
	public static void main(String[] args){
		SparseMatrix obj = new SparseMatrix( new int[][]{{1,0,0},{1,0,1},{0,1,0}} );
//		int[][] arr = obj.getSparse();
//		int[][] arr = obj.transpose();
//		int[][] arr = obj.additionSparse(new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} ));
		int[][] arr = obj.multiplySparse(new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} ), new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} ));

		System.out.println(obj.symmetric());
		for ( int i=0; i<arr.length; i++)
//			for ( int j=0; j<arr[0].length; j++)
			System.out.println( arr[i][0]+""+arr[i][1]+""+arr[i][2]);
//			System.out.println(arr[i][j]);
	}
	

	

	
}

package ru.suhorukov.example;

public class Matrix {

	double[][] matrixData;
	
	public Matrix(){
		matrixData = new double[3][3];
	}
	
	public Matrix summa(Matrix anotherMatrix){
		Matrix result = new Matrix();
		if (this.matrixData.length != anotherMatrix.matrixData.length){
			throw new IllegalArgumentException("Размерности матриц расходятся!");
		}
		else {
			//выполняете код сложения Ваших матриц
//			result.matrixData[i][j] = this.matrixData[i][j] + anotherMatrix.matrixData[i][j];
			return result;
		}
	}
	
	public static void main(String[] args) {
		Matrix matrix1 = new Matrix();
//		matrix1.intiElements();
//		
		Matrix matrix2 = new Matrix();
//		matrix2.intiElements();
		
		try {
			Matrix matrix3 = matrix1.summa(matrix2);
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
//		
//		Matrix matrix3 = matrix1.summa(matrix2);
//		if (matrix3 != null){
//			matrix3.print();
//		}
	}
}

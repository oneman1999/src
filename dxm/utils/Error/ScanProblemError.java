package dxm.utils.Error;

public class ScanProblemError implements IError{

	
	public static String s3 = "Error: Another Housing Nearby or Missing required blocks in the area";
	public static int i2 = IError.ScanError_Category;
	public static String s1 = "ScanProblemError";
	
	
	@Override
	public String getErrorName() {
		return s1;
	}

	@Override
	public int getErrorCategory() {
		return i2;
	}

	@Override
	public String getErrorTextToDisplay() {
		return s3;
	}
	
	public ScanProblemError(String s1 , int i2 , String s3){
		this.s1 = s1;
		this.i2 = i2;
		this.s3 = s3;
	}

}

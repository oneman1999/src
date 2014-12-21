package dxm.utils.Error;

public interface IError {

	
	/**
	 * 
	 * @return the Name of the error
	 */
	public String getErrorName();
	/**
	 * 
	 * @return the category of the error
	 */
	public int getErrorCategory();
	/**
	 * 
	 * @return the text that should be printed on the screen by the error hanler
	 */
	public String getErrorTextToDisplay();
	

	/**
	 * Adding on as the categories become more 
	 */
	public static final int ScanError_Category = 0;
	public static final int MissingItemsError_Category = 1;
	
	
}

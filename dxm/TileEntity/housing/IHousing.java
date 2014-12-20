package dxm.TileEntity.housing;

public interface IHousing {
	
	/**
	 * returns the type of of the housing.
	 * The definition of a housing type is located in 
	 * @return
	 */
	public int getType();
	
	/**
	 * returns and Integer Array containing the area that
	 * the housing effects in 3 dimensions {X , Y , Z}
	 * @return
	 */
	public int[] getAreaOfEffect();
	
	/**
	 * 
	 * @param dimentions
	 * @param the type its going to test for
	 * @returns an Integer array which specifies the types that the housing could be
	 */
	public boolean scan(int[] dimentions , int TypeScanningFor);
	
	/**
	 * Updates the housing and runs a scan for every type of housing
	 */
	public void checkForUpdate();
	
}

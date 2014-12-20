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
	 * @returns true if scan was completed succesfully
	 */
	public boolean scan(int[] dimentions);
	
	
}

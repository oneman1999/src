package dxm.TileEntity.housing;

public enum HousingType {
	
	Apartment(21 , 60 , 21 , 0),
	House(21 , 60 , 21 , 2),
	Homstead(21 , 60 , 21 , 1),
	Hovel(21 , 60 , 21 , 3);
	
	public int x;
	public int y;
	public int z;
	public int type;
	
	
	HousingType(int x , int y , int z , int type){
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
	}
	
	public int[] getDimensionsToScan(){
		return new int[]{ this.x, this.y, this.z};
	}
	
}

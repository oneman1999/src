package dxm.TileEntity.housing;

public enum HousingType {
	
	Apartment(40 , 60 , 40 , 0),
	Homstead(40 , 60 , 40 , 1),
	House(40 , 60 , 40 , 2),
	Hovel(15 , 15 , 15 , 3);
	
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

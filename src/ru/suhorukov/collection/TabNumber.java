package ru.suhorukov.collection;

public class TabNumber {

	private String tabNumber;
	private Integer orderId;

//	public TabNumber(){}
			
	public TabNumber(String tabNumer) {
		this.tabNumber = tabNumer;
	}
	
	public void setId(Integer id){
		this.orderId = id;
	}
	
	private boolean checkTabNumber(){
		return Integer.decode(tabNumber) >= 100 
				&& Integer.decode(tabNumber) <= 10000;
	}
	
	@Override
	public String toString(){
		return tabNumber + (orderId == null ? "" : " : " + orderId);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null || super.equals(obj)){
			return true;
		}
		else {
			if (obj.getClass().equals(this.getClass())){
				TabNumber tab = (TabNumber) obj;
				if (this.tabNumber.equals(tab.tabNumber) && this.orderId == tab.orderId){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = prime + tabNumber.hashCode();
		result += orderId == null ? 0 : orderId.hashCode();
		return result;
//		return 1;
	}
}

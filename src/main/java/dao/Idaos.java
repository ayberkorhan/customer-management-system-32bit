package dao;

import java.util.List;

import model.cust;

public interface Idaos {

	public default  int save() {return 0; };
	
	public default  List<cust> getAll(List<cust> list){
		return list;
	};
}

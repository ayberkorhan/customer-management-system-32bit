package services;

import javax.jws.WebService;

@WebService
public interface Iservice {
	public String Save(String ID ,String FirstName ,String Lastname  ,String Phone_number);

}

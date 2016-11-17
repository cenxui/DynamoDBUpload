package source;

import com.amazonaws.annotation.Immutable;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.services.dynamodbv2.document.Item;

import lib.Customer;

/**
 * This class is used as a generator to produce 
 * a sample customer data. To work more efficiently 
 * @author cenxui
 * 2016/11/16
 */

public class CustomerGenerator {
	private final Customer customer;
	
	public CustomerGenerator(int id) {
		customer = new Customer();
		customer.setId(id);
		
		generateName();
		generateCost();
		generateCount();
		generteBirthday();
		generateHeight();
		generateWeight();	
	}
	
	private void generateName() {
		char v1 = (char)(65 + 26*Math.random());
		char v2 = (char)(97 + 26*Math.random());
		char v3 = (char)(97 + 26*Math.random());
		customer.setName( "" +v1+v2+v3);
	}
	
	private void generateCost() {
		customer.setCost((int) (Math.random()*100000));
	}
	
	private void generateCount() {
		customer.setCount((int) (Math.random()*1000));
	}
	
	private void generteBirthday() {
		int year = (int) (1910 + (int)100*Math.random());
		int month = (int) (1 + (int)30*Math.random());
		int day = (int) (1+ (int)30*Math.random());
		customer.setBirthday("" + year + "-" + month + "-" + day);
	}
	
	private void generateWeight() {
		customer.setWeight(30 +(int)(80*Math.random()));
	}
	
	private void generateHeight() {
		customer.setHeight(140 + (int)(50*Math.random()));
	}
	
	@Override
	public String toString() {
		return customer.toString();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Item getItem() {
		return customer.getItem();
	}
}

package lib;

import org.junit.runner.notification.RunListener.ThreadSafe;

import com.amazonaws.services.dynamodbv2.document.Table;

/**
 * This class use a lazy initializer 
 * which make this project run more efficiently.
 * 
 * @author cenxui
 *
 */

@ThreadSafe
public class CustomerTable {
	
	private static final String tableName = "customer"; 
	
	private static final String ID = "id";
	
	private Table table = CkmatesDynamoDB.getDynamoDB().getTable(tableName);
	
	public static CustomerTable getCustomerTable() {
		
		return Resource.customer;		
	}
	
	private CustomerTable() {
		
	}
	
	private static class Resource {
		private static CustomerTable customer = new CustomerTable(); 
		
	}
	
	public String queryItem(int id) {
		return table.query(ID, id).toString();
	}
	
	public String putItem(Customer custumer) {
		
		return table.putItem(custumer.getItem()).getPutItemResult().toString();
	}
	
	public String deleteItem(int id) {
		return table.deleteItem(ID, id).getDeleteItemResult().toString();
	}
	
}

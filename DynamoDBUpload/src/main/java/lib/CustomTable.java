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
public class CustomTable {
	
	private static final String tableName = "customer"; 
	
	public static Table getCustomTable() {
		
		return Resource.table;
		
	}
	
	static class Resource {
		private static Table table = 
				CkmatesDynamoDB.getDynamoDB().getTable(tableName); 
		
	}
}

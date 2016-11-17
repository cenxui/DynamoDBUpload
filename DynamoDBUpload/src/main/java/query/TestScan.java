package query;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import lib.CkmatesDynamoDB;

public class TestScan {

	public static void main(String[] args) {
		Table table = CkmatesDynamoDB.getDynamoDB().getTable("customer");
		 Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
	        expressionAttributeValues.put(":wei", 70);
	        
	        ItemCollection<ScanOutcome> items = table.scan(
	            "weight < :wei", //FilterExpression
	            "id, weight, height", //ProjectionExpression
	            null, //ExpressionAttributeNames - not used in this example 
	            expressionAttributeValues);
	        items.forEach(System.out::println);
				
				 
			    

	}

}

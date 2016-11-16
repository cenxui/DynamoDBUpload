package query;

import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import data.CustomTable;

public class TestQuery {

	public static void main(String[] args) {
		
		Table table = CustomTable.getCustomTable();
		
		QuerySpec querySpec = new QuerySpec()
				.withKeyConditionExpression("id = :v_id")
			    .withValueMap(new ValueMap()
			        .withInt(":v_id", 1));

		ItemCollection<QueryOutcome> collection =  table.query(querySpec);
		collection.forEach(System.out::println);
		
	}

}

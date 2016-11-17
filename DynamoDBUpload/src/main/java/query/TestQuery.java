package query;

import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import lib.CustomerTable;



public class TestQuery {

	public static void main(String[] args) {

	}

	private static void queryAll(Table table) {
		for (int i= 1; i <= 200; i++) {
			
			QuerySpec querySpec = new QuerySpec()
					.withKeyConditionExpression("id = :v_id")
				    .withValueMap(new ValueMap()
				        .withInt(":v_id", i));
			ItemCollection<QueryOutcome> collection =  table.query(querySpec);
			collection.forEach(System.out::println);
		}
	}

	private static void queryPrimaryKey(Table table, int primaryKey) {
		QuerySpec querySpec = new QuerySpec()
				.withKeyConditionExpression("id = :v_id")
			    .withValueMap(new ValueMap()
			        .withInt(":v_id", primaryKey));

		ItemCollection<QueryOutcome> collection =  table.query(querySpec);
		collection.forEach(System.out::println);
	}

}

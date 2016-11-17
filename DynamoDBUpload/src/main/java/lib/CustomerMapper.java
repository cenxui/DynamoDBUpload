package lib;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class CustomerMapper {
	
	public static void main(String[] args) {
		AmazonDynamoDBClient client = CkmatesDynamoDBClient.getDynamoDBClient();
		
		DynamoDB db = CkmatesDynamoDB.getDynamoDB();
		
		Table table = CustomTable.getCustomTable();
		
		DynamoDBMapper mapper = new DynamoDBMapper(client);

		List<Custumer> list = new ArrayList<>();		
		Custumer custumer;
		for (int i = 3; i <= 200; i++) {
			custumer = mapper.load(Custumer.class,i);
			list.add(custumer);
		}
		mapper.batchDelete(list);
		System.out.println("success");
	}

}

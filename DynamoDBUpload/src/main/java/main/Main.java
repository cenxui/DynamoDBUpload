package main;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import lib.CkmatesDynamoDB;
import lib.CkmatesDynamoDBClient;
import lib.Customer;
import lib.CustomerTable;
import source.CustomerGenerator;

/**
 * 2016/11/16 
 * This is the Main Proccess to generate data to 
 * DynamoDB. However, if there are more data to generate 
 * please please ups multi-threads to generate it and add
 * them to a concurency queue and use upload bunch in DynamoDB
 * sdk.
 * @author cenxui
 * 2016/11/16
 */

public class Main {

	public static void main(String[] args) {
		DynamoDBMapper mapper = new DynamoDBMapper(CkmatesDynamoDBClient.getDynamoDBClient());
		
		System.out.println(mapper.load(Customer.class, 1));
		
		System.out.println("sucess");
	}

	private static void generate() {
		CustomerTable table = CustomerTable.getCustomerTable();
		for (int i = 1; i<= 200; i++) {
			table.putItem(new CustomerGenerator(i).getCustomer());
		}
	}

}

package main;

import com.amazonaws.services.dynamodbv2.document.Table;

import data.CustomTable;
import source.Custumer;

/**
 * 2016/11/16 
 * This is the Main Proccess to generate data to 
 * DynamoDB. However, if there are more data to generate 
 * please please ups multi-threads to generate it and add\
 * them to a concurency queue and use upload bunch in DynamoDB
 * sdk.
 * @author cenxui
 * 2016/11/16
 */

public class Main {

	public static void main(String[] args) {
		Table table = CustomTable.getCustomTable();
		for (int i = 1; i<= 200; i++) {
			table.putItem(new Custumer(i).toItem());
		}
		
		System.out.println("sucess");
	}

}

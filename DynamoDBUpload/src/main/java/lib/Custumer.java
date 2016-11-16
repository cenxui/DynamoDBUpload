package lib;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.google.gson.Gson;

/**
 * This class is used to generate item in
 * clear way With this class we can generate 
 * the customer data in desirable state.
 * @author cenxui
 * 2016/11/16
 */

@DynamoDBTable(tableName="customer")
public class Custumer {
	private int id;
	private String name;
	private int cost;
	private int count;
	private String birthday;
	private int weight;
	private int height;
	
	@DynamoDBHashKey(attributeName="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute(attributeName="cost")
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@DynamoDBAttribute(attributeName="count")
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@DynamoDBAttribute(attributeName="birthday")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	@DynamoDBAttribute(attributeName="weight")
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@DynamoDBAttribute(attributeName="height")
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		
		return new Gson().toJson(this);
	}

}

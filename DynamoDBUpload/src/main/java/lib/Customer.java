package lib;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.google.gson.Gson;

/**
 * This class is used to generate item in
 * clear way With this class we can generate 
 * the customer data in desirable state.
 * @author cenxui
 * 2016/11/16
 */

@DynamoDBTable(tableName="customer")
public class Customer {
	private int id;
	private String name;
	private int cost;
	private int count;
	private String birthday;
	private int weight;
	private int height;
	private Item item;
	
	@DynamoDBHashKey(attributeName="id")
	public int getId() {
		return id;
	}
	
	/**
	 * set key of this customer 
	 * @param id  the customer key
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() {
		return name;
	}
	
	/**
	 * set the user name
	 * @param name user name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute(attributeName="cost")
	public int getCost() {
		return cost;
	}
	
	/**
	 * set the cost of this customer
	 * @param cost the cost of this customer
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@DynamoDBAttribute(attributeName="count")
	public int getCount() {
		return count;
	}
	
	/**
	 * set the count of this customer
	 * @param count the count of this customer
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	@DynamoDBAttribute(attributeName="birthday")
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 *  set the birthday of this customer
	 * @param birthday birthday of this customer
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	@DynamoDBAttribute(attributeName="weight")
	public int getWeight() {
		return weight;
	}
	
	/**
	 * set the weight of this customer
	 * @param weight weight of this customer
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@DynamoDBAttribute(attributeName="height")
	public int getHeight() {
		return height;
	}
	
	/**
	 * set ths height of this customer
	 * @param height height of this customer
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	@DynamoDBIgnore
	public Item getItem() {
		if (item == null) {
			item = new Item();
			item.withPrimaryKey("id", id);
			item.withString("name", name);
			item.withInt("cost", cost);
			item.withInt("count", count);
			item.withString("birthday", birthday);
			item.withInt("height", height);
			item.withInt("weight", weight);
		}
		return item;
	}
	
	@Override
	public String toString() {
		return getItem().toJSON();
	}

}

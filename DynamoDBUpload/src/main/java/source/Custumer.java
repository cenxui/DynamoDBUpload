package source;

import com.amazonaws.annotation.Immutable;
import com.amazonaws.services.dynamodbv2.document.Item;

/**
 * This class is used to generate item in
 * clear way With this class we can generate 
 * the customer data in desirable state.
 * 
 * This class is immutable which make it unchangable
 * and thread safe.
 * @author cenxui
 * 2016/11/16
 */

@Immutable
public class Custumer {
	private final Item item;
	
	public Custumer(int i) {
		item = new Item();
		item.withPrimaryKey("id", i);
		generateName();
		generateCost();
		generateCount();
		generteBirthday();
	}
	
	private void generateName() {
		char v1 = (char)(65 + 26*Math.random());
		char v2 = (char)(97 + 26*Math.random());
		char v3 = (char)(97 + 26*Math.random());
		item.withString("name", "" +v1+v2+v3);
	}
	
	private  void generateCost() {
		item.withInt("cost", (int) (Math.random()*100000));
	}
	
	private void generateCount() {
		item.withInt("count", (int) (Math.random()*1000));
	}
	
	private void generteBirthday() {
		int year = (int) (1910 + (int)100*Math.random());
		int month = (int) (1 + (int)30*Math.random());
		int day = (int) (1+ (int)30*Math.random());
		item.withString("birthday","" + year + "-" + month + "-" + day );
	}
	
	public Item toItem() {
		return item;
	}
	
	@Override
	public String toString() {
		
		return item.toString();
	}

}

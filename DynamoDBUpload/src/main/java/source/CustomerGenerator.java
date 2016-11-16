package source;

import com.amazonaws.annotation.Immutable;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.services.dynamodbv2.document.Item;

import lib.Custumer;

/**
 * This class is used as a generator to produce 
 * a sample customer data. To work more efficiently 
 * it can be used in multi-thread with the thread safe situation.
 * @author cenxui
 * 2016/11/16
 */

@Immutable
@ThreadSafe
public class CustomerGenerator {
	private final Custumer custumer;
	private final Item item;
	
	public CustomerGenerator(int id) {
		custumer = new Custumer();
		custumer.setId(id);
		item = new Item();
		
		generateName();
		generateCost();
		generateCount();
		generteBirthday();
		generateHeight();
		generateWeight();
		
		item.withPrimaryKey("id", custumer.getId());
		item.withString("name", custumer.getName());
		item.withInt("cost", custumer.getCost());
		item.withInt("count", custumer.getCount());
		item.withString("birthday", custumer.getBirthday());
		item.withInt("height", custumer.getHeight());
		item.withInt("weight", custumer.getWeight());
	}
	
	private void generateName() {
		char v1 = (char)(65 + 26*Math.random());
		char v2 = (char)(97 + 26*Math.random());
		char v3 = (char)(97 + 26*Math.random());
		custumer.setName( "" +v1+v2+v3);
	}
	
	private void generateCost() {
		custumer.setCost((int) (Math.random()*100000));
	}
	
	private void generateCount() {
		custumer.setCount((int) (Math.random()*1000));
	}
	
	private void generteBirthday() {
		int year = (int) (1910 + (int)100*Math.random());
		int month = (int) (1 + (int)30*Math.random());
		int day = (int) (1+ (int)30*Math.random());
		custumer.setBirthday("" + year + "-" + month + "-" + day);
	}
	
	private void generateWeight() {
		custumer.setWeight(30 +(int)(80*Math.random()));
	}
	
	private void generateHeight() {
		custumer.setHeight(140 + (int)(50*Math.random()));
	}
	
	@Override
	public String toString() {
		return item.toString();
	}
	
	public Item toItem() {
		return item;
	}
}

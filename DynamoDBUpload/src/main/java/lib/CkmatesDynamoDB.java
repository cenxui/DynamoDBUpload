package lib;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class CkmatesDynamoDB {
	
	private static DynamoDB db;
	
	private CkmatesDynamoDB() {
		
	}
	
	/**
	 * The only information needed to create a client are security credentials
	 * consisting of the AWS Access Key ID and Secret Access Key. All other
	 * configuration, such as the service endpoints, are performed
	 * automatically. Client parameters, such as proxies, can be specified in an
	 * optional ClientConfiguration object when constructing a client.
	 *
	 * @see com.amazonaws.auth.BasicAWSCredentials
	 * @see com.amazonaws.auth.ProfilesConfigFile
	 * @see com.amazonaws.ClientConfiguration
	 */
	private static void initDynamoDB() {
		
		db = new DynamoDB(CkmatesDynamoDBClient.getDynamoDBClient());

	}
	
	
	/**
	 * Check if the db is created, and initial the db client and instance
	 * @return the db instance with desirable configuration.
	 */
	
	public static DynamoDB getDynamoDB() {
		if (db == null) {
			initDynamoDB();
		}
		
		return db;
	}
	
}

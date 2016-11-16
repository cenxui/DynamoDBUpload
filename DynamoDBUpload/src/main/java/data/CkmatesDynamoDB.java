package data;

import com.amazonaws.AmazonClientException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;


/**
 * This class should use eclipse aws configuration file
 * , that makes the code in a safe way deploy, never put 
 * aws credential in your code. That will be very dengerous.
 * @author cenxui
 * 2016/11/16
 */
class CkmatesDynamoDB {

	/*
	 * Before running the code: Fill in your AWS access credentials in the
	 * provided credentials file template, and be sure to move the file to the
	 * default location (/Users/cenxui/.aws/credentials) where the sample code
	 * will load the credentials from.
	 * https://console.aws.amazon.com/iam/home?#security_credential
	 *
	 * WARNING: To avoid accidental leakage of your credentials, DO NOT keep the
	 * credentials file in your source directory.
	 */
	private static AmazonDynamoDBClient  dynamoDB;
	
	
	private static DynamoDB db;

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
	private static void init() {
		/*
		 * The ProfileCredentialsProvider will return your [CKmates (Tokyo)]
		 * credential profile by reading from the credentials file located at
		 * (/Users/cenxui/.aws/credentials).
		 */
		AWSCredentials credentials = null;
		try {
			credentials = new ProfileCredentialsProvider("CKmates (Tokyo)").getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (/Users/cenxui/.aws/credentials), and is in valid format.", e);
		}
		
		if (dynamoDB == null) {
			dynamoDB = new AmazonDynamoDBClient(credentials);
			Region apNorthEast2 = Region.getRegion(Regions.AP_NORTHEAST_1);
			dynamoDB.setRegion(apNorthEast2);
		}
		
		db = new DynamoDB(dynamoDB);

	}
	
	/**
	 * Check if the db is created, and initial the db client and instance
	 * @return the db instance with desirable configuration.
	 */
	
	public static DynamoDB getDynamoDB() {
		if (db == null) {
			init();
		}
		return db;
	}
}

package lib;

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
public class CkmatesDynamoDBClient {

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
	
	private CkmatesDynamoDBClient() {
		
	}

	private static AWSCredentials getCredentials() {
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
		return credentials;
	}
		

	private static void initialDynamoDBClient() {
		dynamoDB = new AmazonDynamoDBClient(getCredentials());
		Region apNorthEast2 = Region.getRegion(Regions.AP_NORTHEAST_1);
		dynamoDB.setRegion(apNorthEast2);
	}

	/**
	 * check if initial. The instance is useful to control higher level
	 * DynamoDB sdk method.
	 * @return the instance of AmazonDynamoDBClient
	 */
	
	public static AmazonDynamoDBClient getDynamoDBClient () {
		if (dynamoDB == null) {
			initialDynamoDBClient();
		}
		
		return dynamoDB;
	}
}

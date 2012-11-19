package org.mobileTAO.mongoDB.hello;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

//http://www.mongodb.org/display/DOCS/Java+Tutorial#JavaTutorial-MakingAConnection
public class HelloMongoDB {
	public static void main(String [] args){
		//create mongoDB connection
		try {
		Mongo mongoConnection = new Mongo("localhost", 27017); // default port
		//get database. if database does not exist
		//mongoDB would automatically create one for you
		DB mongoDB = mongoConnection.getDB("mongoDB"); 
		
		//authentication -- optional
		//boolean auth = mongoDB.authenticate(username, password);
		
		DBCollection collection = mongoDB.getCollection("testmongoDB");
		
		//create document
		BasicDBObject document = new BasicDBObject();
		document.put("name", "dilasasiko");
		document.put("message", "helloMongoDB");
		
		//insert document to collection
		collection.insert(document);
		
		mongoConnection.setWriteConcern(WriteConcern.SAFE);
		//query for the inserted document
		DBObject findOneResult = collection.findOne();
		System.out.println(findOneResult);
		
		}
		catch (MongoException mongoexcp){
			mongoexcp.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
			System.out.println();
		}
}

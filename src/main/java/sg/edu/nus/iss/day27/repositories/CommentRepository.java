package sg.edu.nus.iss.day27.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day27.models.Comment;

@Repository
public class CommentRepository {
    
	// Name of the MongoDB collection used to store comments
    public static String COLLECTION_COMMENTS = "comments";

	// Instance of the MongoTemplate class that is injected into this class
	@Autowired
	private MongoTemplate template;

	// This method inserts a Comment object into the MongoDB collection
	public void insertComment(Comment comment) {
		// Converts the Comment object to a MongoDB document
		Document doc = comment.toDocument();
		// Inserts the document into the MongoDB collection using the MongoTemplate instance
		template.insert(doc, COLLECTION_COMMENTS);
    }
}

package sg.edu.nus.iss.day27.models;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

public class Comment {
    
    private String commentId;
	private int gameId;
	private String userName;
	private int rating;
	private String comment;


    // Getters and Setters
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // This method converts the Comment object to a MongoDB document
    public Document toDocument() {
        // Creates a new empty Document object.
		Document doc = new Document();
		doc.put("c_id", getCommentId());
		doc.put("user", getUserName());
		doc.put("rating", getRating());
		doc.put("c_text", getComment());
		return doc;
	}

    // This method returns a string representation of the Comment object
	@Override
	public String toString() {
		return "Comment[commentId=%s, username=%s, rating=%d, comment=%s]"
			.formatted(commentId, userName, rating, comment);
	}

    // This method creates a Comment object from form data
	public static Comment create(MultiValueMap<String, String> form) {
		Comment comment = new Comment();
		comment.setGameId(
			Integer.parseInt(form.getFirst("gameId"))
		);
		comment.setUserName(form.getFirst("username"));
		comment.setRating(
			Integer.parseInt(form.getFirst("rating"))
		);
		comment.setComment(form.getFirst("comment"));
		return comment;
	}
}

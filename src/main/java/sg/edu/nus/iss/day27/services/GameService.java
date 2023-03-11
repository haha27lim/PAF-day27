package sg.edu.nus.iss.day27.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day27.models.Comment;
import sg.edu.nus.iss.day27.models.Game;
import sg.edu.nus.iss.day27.repositories.CommentRepository;
import sg.edu.nus.iss.day27.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
	private GameRepository gameRepo;

    @Autowired
	private CommentRepository commentRepo;

	// This method retrieves a list of games with default parameters (30, 0)
	public List<Game> getGames() {
		return getGames(30, 0);
	}
	// This method retrieves a list of games with specified limit and offset parameters
	public List<Game> getGames(int limit, int offset) {
		return gameRepo.getGames(limit, offset);
	}
    // This method retrieves a single Game object with the specified gameId
    public Optional<Game> getGameByGameId(int gameId) {
		return gameRepo.getGameByGameId(gameId);
	}
	// This method adds a Comment object to the MongoDB collection and returns the generated comment ID
    public String addComment(Comment comment) {
		// Generate a unique comment ID using UUID and substring it to first 8 characters
		String commentId = UUID.randomUUID().toString().substring(0, 8);
		// Set the generated comment ID to the Comment object
		comment.setCommentId(commentId);
		// Insert the Comment object to the MongoDB collection using commentRepo
		commentRepo.insertComment(comment);
		// Return the generated comment ID
		return commentId;
	}

}

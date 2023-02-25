package sg.edu.nus.iss.day27.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day27.models.Comment;
import sg.edu.nus.iss.day27.models.Game;
import sg.edu.nus.iss.day27.services.GameService;

@Controller
@RequestMapping(path="/game")
public class GameController {
    
    @Autowired
    private GameService gameSvc;

	// Handles GET requests to the "/game/{gameId}" path
    @GetMapping("/{gameId}")
	public String getGame(Model model, @PathVariable int gameId) {

		// Get the Game object corresponding to the provided gameId using the injected GameService
		Optional<Game> opt = gameSvc.getGameByGameId(gameId);

		// Add the gameId to the Model object
		model.addAttribute("gameId", gameId);

		// If the Game object was not found, return a "not-found" view
		if (opt.isEmpty())
			return "not-found";
		// Add the Game object to the Model object
		model.addAttribute("game", opt.get());

		return "display-game";
	}

	// Handles POST requests to the "/game/comment" path
    @PostMapping("/comment")
	public String postComment(@RequestBody MultiValueMap<String, String> form) {
		// Create a Comment object from the POST form data
		Comment comment = Comment.create(form);
		// Add the comment to the GameService and get the comment ID
		String commentId = gameSvc.addComment(comment);
		// Print the comment ID to the console for debugging purposes
		System.out.printf(">>>> commentId: %s\n", commentId);
		// Redirect to the home page
		return "redirect:/";
	}

}

package sg.edu.nus.iss.day27.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import sg.edu.nus.iss.day27.models.Game;
import sg.edu.nus.iss.day27.services.GameService;

@Controller
@RequestMapping (path={"/", "/index.html"})
public class IndexController {
    
    @Autowired
    private GameService gameSvc;

    // Handler method for HTTP GET requests to the root path or "/index.html"
    @GetMapping
    public String getAllGame(@RequestParam(required = false, defaultValue = "30") int limit,
            @RequestParam(required = false, defaultValue = "0")  int offset, Model model) {
        
        // Get a list of games from the GameService with the given limit and offset
        List<Game> games = gameSvc.getGames(limit, offset);
        // Add the list of games to the model as an attribute named "games"
        model.addAttribute("games", games);
        // Add the starting index for the next page of games to the model as an attribute named "next"
        model.addAttribute("next", offset + limit);
        return "index";
    }
}

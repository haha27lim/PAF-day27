package sg.edu.nus.iss.day27.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day27.models.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static sg.edu.nus.iss.day27.repositories.Queries.*;


@Repository
public class GameRepository {
    
	// instance of the JdbcTemplate class that is injected into this class
    @Autowired
	private JdbcTemplate template;

	// gid, name
	// This method retrieves a list of games with default parameters (30, 0)
	public List<Game> getGames() {
		return getGames(30, 0);
	}
	// This method retrieves a list of games with specified limit and offset parameters
	public List<Game> getGames(int limit, int offset) {
		// Retrieves the result set of games from the database using the JdbcTemplate instance
		SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAMES, limit, offset);

		// Creates a list of Game objects from the result set
		List<Game> games = new LinkedList<>();
		while (rs.next())
			games.add(Game.createSummary(rs));

		return games;
    }

	// This method retrieves a single Game object with the specified gameId
    public Optional<Game> getGameByGameId(int gameId) {
		// Retrieves the result set of the Game object with the specified gameId from the database using the JdbcTemplate instance
		SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_BY_GID, gameId);

		// If the result set is empty, this returns an empty Optional object
		if (!rs.next())
			return Optional.empty();

		// Creates a Game object from the result set and returns it as an Optional object
		return Optional.of(Game.create(rs));
	}
}

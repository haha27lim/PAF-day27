package sg.edu.nus.iss.day27.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {
    
    private int gameId;
	private String name;
	private int ranking;
	private String url;
	private String image;

    // Getters and setters
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    // This method is used to create a Game object with gameId and name properties from the SQL result set
    public static Game createSummary(SqlRowSet rs) {
		Game game = new Game();
		game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		return game;
	}
    
    // This method is used to create a Game object with gameId, name, ranking, url, and image properties from the SQL result set
    public static Game create(SqlRowSet rs) {
		Game game = new Game();
		game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		game.setRanking(rs.getInt("ranking"));
		game.setUrl(rs.getString("url"));
		game.setImage(rs.getString("image"));
		return game;
	}
}

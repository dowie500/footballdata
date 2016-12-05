package dpball.footballdata.entities;

import java.util.ArrayList;

public class Team {

	public Links _links;
	public int count;
	public ArrayList<Player> players = new ArrayList<Player>();

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}

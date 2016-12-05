package dpball.footballdata.entities;

public class Player {

	public String name;
	public String position;
	public int jerseyNumber;
	public String dateOfBirth;
	public String nationality;
	public String contractUntil;
	public String MarketValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getContractUntil() {
		return contractUntil;
	}

	public void setContractUntil(String contractUntil) {
		this.contractUntil = contractUntil;
	}

	public String getMarketValue() {
		return MarketValue;
	}

	public void setMarketValue(String marketValue) {
		MarketValue = marketValue;
	}

}

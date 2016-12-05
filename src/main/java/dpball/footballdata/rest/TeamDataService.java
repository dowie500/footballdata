package dpball.footballdata.rest;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import dpball.footballdata.entities.Team;


public class TeamDataService {
	
	private Team team;

	private int teamNumber = 66;
	private String webhost = "http://api.football-data.org/";
	private String endpoint = webhost + "v1/teams/" + teamNumber + "/players";

    private static final Logger LOGGER = Logger.getLogger(TeamDataService.class);

	public TeamDataService()
	{
		LOGGER.info("TeamDataService Obj created");
	}

	public void load()
	{
		LOGGER.info("Attempting call to endpoint");
		try
		{
			ClientRequest request = new ClientRequest(endpoint);
			request.accept("application/json");
			
			ClientResponse<Team> response = request.get(Team.class);
			
			if (response.getStatus() != 200)
			{
				throw new RuntimeException("FAILED: HTTP error code : " + response.getStatus());
			}
			
			LOGGER.info(response.getEntity());
			
		} catch (ClientProtocolException e)
		{
			LOGGER.error("Something has gone wrong : \n" + e);
		} catch (Exception e) {
			LOGGER.error("Something has gone wrong : \n" + e);
		}
	
		LOGGER.info("Team Data should've returned by now");
	}

}

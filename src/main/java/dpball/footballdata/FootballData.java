package dpball.footballdata;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import dpball.footballdata.rest.TeamDataService;

public class FootballData extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(FootballData.class);

    public void init() throws ServletException {
        // TODO Auto-generated method stub
        System.out.print("Starting application......");

        LOGGER.info("Starting application at " + LocalDateTime.now());
        
        LOGGER.info("Checking online football data stores for new data");
        
        try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        TeamDataService testTeamData = new TeamDataService();
        testTeamData.load();
        


    }

}

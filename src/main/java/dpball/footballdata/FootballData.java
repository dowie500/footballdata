package dpball.footballdata;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class FootballData extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FootballData.class);

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.print("Starting application......");
//		
//		logger.info("Starting application...logging to log");
//
//	}

	public void init() throws ServletException
	{
		// TODO Auto-generated method stub
		System.out.print("Starting application......");
		
		logger.info("Starting application...logging to log");
		logger.warn("THis is a warning message");
		
		person p1 = new person("Daniel", 35);
		person p2 = new person("Martijn", 33);
		
		logger.info("Person created " + p1.getName() + ", aged " + p1.getAge());
		logger.error("Person created " + p2.getName() + ", aged " + p2.getAge());

		p1.setAge(21);
		
		logger.info("Person created " + p1.getName() + ", aged " + p1.getAge());
	}

}

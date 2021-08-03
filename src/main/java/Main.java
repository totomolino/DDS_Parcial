import Business.Views.menu;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

import static org.quartz.JobBuilder.newJob;

public class Main {



    public static void main(String[] args) throws IOException, SchedulerException {

        //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

       // scheduler.start();

    //    JobDetail job = newJob();

        menu unMenu = new menu();

        unMenu.iniciarMenu();

       // scheduler.shutdown();
    }




}

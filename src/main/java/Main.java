import Business.Views.menu;
import Sistema.Sistema;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Main {

    private static menu unMenu = new menu();

    public static void main(String[] args) throws IOException, SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail job = newJob(AvisarFecha.class)
                .withIdentity("avisar_retraso")
                .build();

       SimpleTrigger trigger =  newTrigger().withIdentity("trigger1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(15).repeatForever())
                //.withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever())
                .build();
                //.withSchedule(simpleSchedule().withIntervalInHours(24).repeatForever())

        scheduler.scheduleJob(job, trigger);

        unMenu.iniciarMenu();

       // scheduler.shutdown();
    }


    public static class AvisarFecha implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            Sistema sistema = Sistema.getInstance();
            sistema.avisarFechaDevolucion();
        }
    }
}

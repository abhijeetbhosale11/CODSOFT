package QuizApp;
import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
    private Timer timer;
    private int timeLimit;

    public QuizTimer(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handleTimeUp();
            }
        }, timeLimit * 1000);
    }

    public void stopTimer() {
        timer.cancel();
    }

    private void handleTimeUp() {
        System.out.println("Time's up!");
    }
}

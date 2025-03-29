import greenfoot.*;

/**
 * The timer that is displayed at the bottom of the world which shows the player how much time they have left to complete their orders
*/
public class Timer extends Actor {
    private SimpleTimer timer;
    private int totalSeconds;
    private GreenfootImage timerImage;
    private final Color DEFAULT_COLOR = Color.WHITE;
    private final Color ALERT_COLOR = Color.RED;
    private final int ALERT_THRESHOLD = 30;
    private boolean timerRunning = true;
    private boolean isGameOver = false;

    public Timer(int initialSeconds) {
        this.totalSeconds = initialSeconds;
        this.timer = new SimpleTimer();
        timer.mark();
        timerImage = new GreenfootImage(100, 30);
        setImage(timerImage);
        updateImage();
    }
    
    /**
     * Deals with the timer countdown logic
     */
    public void act() {
        if (timerRunning) {
            int elapsedMillis = timer.millisElapsed();
            int elapsedSeconds = elapsedMillis / 1000;

            if (elapsedSeconds >= 1) {
                totalSeconds--;
                timer.mark();
                updateImage();

                if (totalSeconds <= 0) {
                    totalSeconds = 0;
                    isGameOver = true;
                    timerRunning = false;
                }
            }
        }
    }
    
    /**
     * Formats and updates the timer every second.
     * When there are only 30 seconds left, the timer goes red.
     */
    private void updateImage() {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String timeString = String.format("%02d:%02d", minutes, seconds);

        timerImage.clear();
        timerImage.setFont(new Font("Arial", true, false, 28));
        Color textColor = (totalSeconds <= ALERT_THRESHOLD) ? ALERT_COLOR : DEFAULT_COLOR;
        timerImage.setColor(textColor);
        timerImage.drawString(timeString, 0, 20);
        setImage(timerImage);
    }
    
    /**
     * Method to check is the game is over
     */
    public boolean gameOver() {
        return isGameOver;
    }
    
    /**
     * Shows the gameOver textbox
     */
    public void showGameOver() {
        World world = getWorld();
        Textbox gameOverTextbox = new Textbox("images/game-over.png");
        world.addObject(gameOverTextbox, world.getWidth() / 2, world.getHeight() / 2);
    }
    
    /**
     * Stops the timer
     */
    public void stop() {
        timerRunning = false;
    }
    
    /**
     * Resumes the timer
     */
    public void resume() {
        timerRunning = true;
    }
}

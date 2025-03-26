import greenfoot.*;
/**
 * The game world
 * 
 */
public class MyWorld extends World {
    public static final int WORLD_WIDTH = 1400;
    public static final int WORLD_HEIGHT = 600;
    private Timer timer;
    private Hatch hatch;
    private boolean gameStarted = false;

    public MyWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        showStartScreen();
    }

    // The intial world which is the menu where the game can be started and the instrcutions can be viewed
    private void showStartScreen() {
        GreenfootImage startScreen = new GreenfootImage("images/menu.png");
        setBackground(startScreen);

        Button startButton = new Button("Start Game", () -> startGame());
        addObject(startButton, WORLD_WIDTH / 2, WORLD_HEIGHT / 2);

        Button instructionsButton = new Button("Instructions", () -> showInstructions());
        addObject(instructionsButton, WORLD_WIDTH / 2, WORLD_HEIGHT / 2 + 100);
    }

    private void showInstructions() {
        Textbox instructionsTextbox = new Textbox("images/instructions.png");
        addObject(instructionsTextbox, WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
    }

    private void startGame() {
        if (!gameStarted) {
            gameStarted = true;
            prepare();
        }
    }
    
    //loads the main game world
    private void prepare() {
        GreenfootImage background = new GreenfootImage("images/background.png");
        removeObjects(getObjects(null)); // Clear the start menu

        background.scale(WORLD_WIDTH, WORLD_HEIGHT);
        setBackground(background);

        InventoryUI inventoryUI = new InventoryUI();

        Player player = new Player(inventoryUI);
        addObject(player, 500, 250);

        addObject(new Counter(), 1075, 475);
        addObject(new Counter(), 1075, 425);
        addObject(new Counter(), 1025, 475);
        addObject(new Counter(), 975, 475);
        addObject(new Counter(), 925, 475);

        addObject(new Counter(), 1075, 25);
        addObject(new Counter(), 1025, 25);
        addObject(new Counter(), 975, 25);
        addObject(new Counter(), 1075, 75);
        addObject(new Counter(), 1075, 125);

        addObject(new Counter(), 875, 225);
        addObject(new Counter(), 825, 225);
        addObject(new Counter(), 775, 225);
        addObject(new Counter(), 875, 275);
        addObject(new Counter(), 725, 225);
        addObject(new Counter(), 675, 225);
        addObject(new Counter(), 675, 275);

        addObject(new Counter(), 475, 25);
        addObject(new Counter(), 525, 25);
        addObject(new Counter(), 575, 25);
        addObject(new Counter(), 625, 25);

        // Wall between kitchen and restaurant - counters work for now, left a
        // gap for service hatch object
        addObject(new Counter(), 425, 25);
        addObject(new Counter(), 425, 75);
        addObject(new Counter(), 425, 125);
        addObject(new Counter(), 425, 175);
        addObject(new Counter(), 425, 325);
        addObject(new Counter(), 425, 375);
        addObject(new Counter(), 425, 425);
        addObject(new Counter(), 425, 475);

        addObject(inventoryUI, 100, 550);

        addObject(new Hob(), 875, 475);
        addObject(new ChoppingBoard(), 475, 475);
        hatch = new Hatch();
        addObject(hatch, 425, 250);

        Ingredient carrot = IngredientFactory.createVegetableIngredient("carrot", 10, 10, 30);
        // We dont have any vegetables that need cooking - redundant
        Ingredient bread = IngredientFactory.createStandardIngredient("bread", 5);
        
        Ingredient lettuce = IngredientFactory.createStandardIngredient("lettuce", 5);
        Ingredient tomato = IngredientFactory.createStandardIngredient("tomato", 5);
        Ingredient bacon = IngredientFactory.createMeatIngredient("bacon", 10, 10, 30);
        // ----- Ingredients should be instantiated in Storage class!!! ------
        // pass in name string (e.g. "bread") to Storage object and create ingredient accordingly

        addObject(new Storage(lettuce), 1075, 375);
        addObject(new Counter(), 1075, 325);
        addObject(new Storage(tomato), 1075, 275);
        addObject(new Counter(), 1075, 225);
        addObject(new Storage(bacon), 1075, 175);
        addObject(new Counter(), 1075, 125);

        addObject(new Plate(), 675, 25);

        addObject(new Storage(bread), 675, 475);
        addObject(new Counter(), 525, 475);
        addObject(new Counter(), 575, 475);
        addObject(new Counter(), 625, 475);
        addObject(new Counter(), 725, 475);
        addObject(new Counter(), 775, 475);
        addObject(new Counter(), 825, 475);
        
        addObject(new Bin(), 925, 25);
        addObject(new Sign(), 750, 550);

        timer = new Timer(300);
        addObject(timer, 300, 557);
    }
    public void act() {
        if (gameStarted && timer != null &&  timer.gameOver()) {
            timer.showGameOver();
        }
        if (gameStarted && hatch != null && hatch.gameCompleted()){
            timer.stop();
            hatch.showGameCompleted();
        }
        if (gameStarted && (timer != null &&timer.gameOver()|| hatch != null && hatch.gameCompleted()) && Greenfoot.isKeyDown("space")) {
            resetGame();
        }
        
        // showText((getObjects(Ticket.class)).toString(), 100, 100);
    }

    private void resetGame() {
        removeObjects(getObjects(null));
        gameStarted = false;
        showStartScreen();
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Player extends Actor {
    private int count = 0;
    private int animationSpeed = 10;  
    private int animationTimer = 0;
    private Ingredient inventoryIngredient;
    private CompletedDish completedDish;
    private Ticket currentTicket;
    
    GreenfootImage standingImg = new GreenfootImage("images/standing-char.png");
    GreenfootImage[] down = {
        new GreenfootImage("images/down-char1.png"),
        new GreenfootImage("images/down-char2.png")
    };
    GreenfootImage[] right = {
        new GreenfootImage("images/right-char1.png"),
        new GreenfootImage("images/right-char2.png")
    };
    GreenfootImage[] left = {
        new GreenfootImage("images/left-char1.png"),
        new GreenfootImage("images/left-char2.png")
    };
    GreenfootImage[] up = {
        new GreenfootImage("images/up-char1.png"),
        new GreenfootImage("images/up-char2.png")
    };

    public Player() {
        this.inventoryIngredient = null;
        this.completedDish = null;
        final int PLAYER_WIDTH = 36;
        final int PLAYER_HEIGHT = 63;
        
        standingImg.scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        setImage(standingImg);
        
        down[0].scale(PLAYER_HEIGHT, PLAYER_WIDTH);
        down[1].scale(PLAYER_HEIGHT, PLAYER_WIDTH);
        
        right[0].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        right[1].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        
        left[0].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        left[1].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        
        up[0].scale(PLAYER_HEIGHT, PLAYER_WIDTH);
        up[1].scale(PLAYER_HEIGHT, PLAYER_WIDTH);
    }

    public void act() {
        movement();
      
    }

    public void animate(GreenfootImage[] imgs) {
        animationTimer++;  // Increases every frame

        if (animationTimer % animationSpeed == 0) { 
            setImage(imgs[count]);
            count = (count + 1) % imgs.length;  // Loop between 0 and 1
        }
    }

    public void handleCollision(int x, int y){
        if (isTouching(Obstacle.class)) {
                setLocation(x, y);
            }
    }
    
    public void movement() {
        boolean isMoving = false;
        GreenfootImage[] direction = null;
        int x = getX();
        int y = getY();
        
        if (Greenfoot.isKeyDown("W")) {
            setRotation(270);
            direction = up;
            isMoving = true;
            move(1);
            handleCollision(x,y);
        }
        else if (Greenfoot.isKeyDown("A")) {
            setRotation(180);
            direction = left;
            isMoving = true;
            move(1);
            handleCollision(x,y);
        }
        else if (Greenfoot.isKeyDown("S")) {
            setRotation(90);
            direction = down;
            isMoving = true;
            move(1);
            handleCollision(x,y);
        }
        else if (Greenfoot.isKeyDown("D")) {
            setRotation(0);
            direction = right;
            isMoving = true;
            move(1);
            handleCollision(x,y);
        }

        // If moving, animate
        if (isMoving) {
            if (count == 0) {
                setImage(direction[1]);
            }
            animate(direction);
            if (inventoryIngredient != null){
                inventoryIngredient.setLocation(x + MyWorld.INGREDIENT_ICON_OFFSET,y + MyWorld.INGREDIENT_ICON_OFFSET);
            }
            if (completedDish != null){
                completedDish.setLocation(x + MyWorld.INGREDIENT_ICON_OFFSET,y + MyWorld.INGREDIENT_ICON_OFFSET);
            }
            
        } else {
            setRotation(0);
            setImage(standingImg);
            count = 0;  // Reset animation when stopping
        }
    
    }

    public Ingredient getInventoryIngredient() {
        return inventoryIngredient;
    }

    public void storeInventoryIngredient(Ingredient ingredient) {
        inventoryIngredient = ingredient;
        ingredient.setIngredientLocation(Location.INVENTORY);
        inventoryIngredient.setLocation(getX() + MyWorld.INGREDIENT_ICON_OFFSET,
                getY() + MyWorld.INGREDIENT_ICON_OFFSET);
    }

    public Ingredient useInventoryIngredient() {
        Ingredient ingredient = inventoryIngredient;
        inventoryIngredient = null;
        return ingredient;
    }

    public CompletedDish getCompletedDish() {
        return completedDish;
    }

    public void setCompletedDish(CompletedDish dish) {
        completedDish = dish;
        if (dish != null) {
            completedDish.setLocation(getX() + MyWorld.INGREDIENT_ICON_OFFSET,
                    getY() + MyWorld.INGREDIENT_ICON_OFFSET);
        }
    }

    public Ticket getTicket() {
        return currentTicket;
    }

    public void setTicket(Ticket ticket) {
        if (currentTicket != null) {
            getWorld().removeObject(currentTicket);
        }
        currentTicket = ticket;
        getWorld().addObject(currentTicket, 1250, 300);
    }

}
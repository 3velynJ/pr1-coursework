import greenfoot.*; 
import java.util.List;
/**
 * The logic for the player character
 */
public class Player extends Actor {
    private int count = 0;
    private int animationSpeed = 10;  
    private int animationTimer = 0;
    private Ingredient playerInventory;
    private InventoryUI inventoryUI;
    
    GreenfootImage standing_img = new GreenfootImage("images/standing-char.png");
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

    public Player(InventoryUI inventoryUI) {
        this.inventoryUI = inventoryUI;
        this.playerInventory = null;
        
        standing_img.scale(36, 63);
        setImage(standing_img);
        
        down[0].scale(63, 36);
        down[1].scale(63, 36);
        
        right[0].scale(36, 63);
        right[1].scale(36, 63);
        
        left[0].scale(36, 63);
        left[1].scale(36, 63);
        
        up[0].scale(63, 36);
        up[1].scale(63, 36);
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
        } else {
            setRotation(0);
            setImage(standing_img);
            count = 0;  // Reset animation when stopping
        }
    }
     public void updateInventoryUI(){
    if(playerInventory != null) {
        inventoryUI.updateInventoryUI(playerInventory.getRelativePath());
    } else {
        inventoryUI.updateInventoryUI(null);
    }
    }
     public void setInventory(Ingredient ingredient) {
         playerInventory = ingredient;
     }
     
     public Ingredient getInventory() {
         return playerInventory;
     }
}






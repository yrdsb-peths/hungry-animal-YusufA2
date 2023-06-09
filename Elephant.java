import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Elephant 
 * 
 * @author Yusuf 
 * @version May 2023
 */
public class Elephant extends Actor
{ 
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for(int i = 0; i < 8; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        
        }
        setImage(idle[0]);
        
        
    }
    
    /**
     * Animate the elephant
     */
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
        
        
        
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        //Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
       if(isTouching(Apple.class))
        {
            removeTouching(Apple.class); 
            MyWorld world = (MyWorld) getWorld();
            world.creatApple();
            world.icreaseScore();
            elephantSound.play();
        }
    }
}

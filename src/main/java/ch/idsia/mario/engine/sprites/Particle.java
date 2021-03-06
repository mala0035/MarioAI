package ch.idsia.mario.engine.sprites;

import ch.idsia.mario.engine.Art;
import ch.idsia.mario.engine.LevelScene;

public class Particle extends Sprite //cloneable
{
    private int life;
    
    public Particle(LevelScene world,int x, int y, float xa, float ya)
    {
        this(world,x, y, xa, ya, (int)(Math.random()*2), 0);
    }

    public Particle(LevelScene world,int x, int y, float xa, float ya, int xPic, int yPic)
    {
    	this.spriteContext=world;
        kind = KIND_PARTICLE;
        sheet = Art.particles;
        this.x = x;
        this.y = y;
        this.xa = xa;
        this.ya = ya;
        this.xPic = xPic;
        this.yPic = yPic;
        this.xPicO = 4;
        this.yPicO = 4;
        
        wPic = 8;
        hPic = 8;
        life = 10;
    }
    
    public Particle(LevelScene alreadyCopied,Particle toCopy) {
    	super(alreadyCopied,toCopy);

    	this.life=toCopy.life;
    }

    public void move()
    {
        if (life--<0) this.spriteContext.removeSprite(this);
        x+=xa;
        y+=ya;
        ya*=0.95f;
        ya+=3;
    }
}
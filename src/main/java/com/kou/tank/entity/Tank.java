package com.kou.tank.entity;

import com.kou.tank.enume.TankDirEnum;
import com.kou.tank.enume.TankEnum;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author JIAJUN KOU
 */
@Data
public class Tank {

    // 坦克位置
    private int x;

    private int y;

    private TankDirEnum dirEnum;

    private boolean bL,bU,bR,bD;

    // 坦克移动速度
    private static  final int SPEED = 5;

    // 坦克是否该移动
    private boolean moving = false;

    // 坦克名称
    private String title;

    // 坦克等级
    private int level;

    public Tank(int x, int y, TankDirEnum dirEnum, String title, int level) {
        this.x = x;
        this.y = y;
        this.dirEnum = dirEnum;
        this.title = title;
        this.level = level;
    }

    // 画坦克
    public void paint(Graphics g) {
        try {
            BufferedImage tankImg = ImageIO.read(Objects.requireNonNull(Tank.class.getClassLoader().getResourceAsStream("static/logo.png")));

            g.drawImage(tankImg,x,y,TankEnum.SIZE_X.getSize(),TankEnum.SIZE_Y.getSize(),null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        move();
    }

    // 键盘按一下 就东一下
    public void keyPressed(KeyEvent e) {
        System.out.println("按下键盘");
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }

        // 确定移动方向
        setMainDir();

    }

    private void setMainDir() {

        moving = bL || bU || bR || bD;

        if (bL && !bU && !bR && !bD){
            dirEnum = TankDirEnum.L;
        }
        if (!bL && bU && !bR && !bD){
            dirEnum = TankDirEnum.U;
        }
        if (!bL && !bU && bR && !bD){
            dirEnum = TankDirEnum.R;
        }
        if (!bL && !bU && !bR && bD){
            dirEnum = TankDirEnum.D;
        }
    }

    private void move() {
        if (!moving) return;
        switch (dirEnum){
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }

    }


    public void keyReleased(KeyEvent e) {
        System.out.println("松开键盘");
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        // 确定移动方向
        setMainDir();

    }
}

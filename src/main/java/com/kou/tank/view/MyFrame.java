package com.kou.tank.view;

import com.kou.tank.entity.Tank;
import com.kou.tank.enume.TankDirEnum;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author JIAJUN KOU
 */
@Slf4j
public class MyFrame extends Frame {

    Tank mytTank;
    Tank enemy;

    public MyFrame() {
        this.setTitle("King Tank Game……");
        this.setLocation(400,100);
        this.setSize(800,600);

        this.addKeyListener(new TankKeyListener());

        // 初始化坦克
        mytTank = new Tank(100, 100, TankDirEnum.R,"KING", 1);
        enemy = new Tank(300, 400, TankDirEnum.D,"enemy", 2);


    }

    @Override
    public void paint(Graphics g) {
        mytTank.paint(g);
        log.info(mytTank.getTitle() + ": Tank 绘画完成……");
        enemy.paint(g);
        log.info(enemy.getTitle() + ": Tank 绘画完成……");

    }

    private  class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            mytTank.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            mytTank.keyReleased(e);

        }
    }
}

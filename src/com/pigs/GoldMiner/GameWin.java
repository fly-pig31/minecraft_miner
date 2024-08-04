package com.pigs.GoldMiner;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {
    Image bg =Toolkit.getDefaultToolkit().getImage("src/com/pigs/GoldMiner/win.jpg");
    void lanuch() {
        this.setVisible(true);
        this.setSize(500, 500);
//        设置窗口位置
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, this);
    }
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.lanuch();
    }
}

package com.pigs.GoldMiner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.Random;

public class GameWin extends JFrame {
    private final Image bg_dirt = Toolkit.getDefaultToolkit().getImage("images/dirt.png");
    private final Image bg_stone = Toolkit.getDefaultToolkit().getImage("images/stone.png");
    private final Image bg_glass = Toolkit.getDefaultToolkit().getImage("images/glass.png");
    private final Image bg_grass = Toolkit.getDefaultToolkit().getImage("images/grass_block_side.png");
    // 图片的大小32x32pixels
    //将Size*2可以将背景图片放大两倍
    private final int bgSize = 32 ;

    public GameWin() {
        this.setTitle("黄金矿工");
        //方块层数
        int frameFloor = 30;
        //每行的方块个数
        int lineCount = 20;
        int frameWidth = lineCount * bgSize;

        this.setSize(frameWidth, frameFloor * bgSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 绘制上半部分的图片
                for (int i = 0; i < lineCount; i++) {
                    for (int j = 0; j < frameFloor; j++) {
//                        g.drawImage(j == 0 ? bg_grass : j == 1 ? bg_dirt : j == 2 ? new Random().nextBoolean() ? bg_stone : bg_dirt : bg_stone, i * bgSize, j * bgSize, bgSize, bgSize, this);
                        switch (j) {
                            case 0:
                                g.drawImage(bg_grass, i * bgSize, 0, bgSize, bgSize, this);
                                break;
                            case 1:
                                g.drawImage(bg_dirt, i * bgSize, j * bgSize, bgSize, bgSize, this);
                                break;
                            case 2:
                                g.drawImage(new Random().nextBoolean() ? bg_stone : bg_dirt, i * bgSize, j * bgSize, bgSize, bgSize, this);
                                break;
                            default:
                                g.drawImage(bg_stone, i * bgSize, j * bgSize, bgSize, bgSize, this);
                                break;
                        }
                    }
                }
            }
        };

        this.add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWin gameWin = new GameWin();
            gameWin.setVisible(true);
        });
    }
    // 将Image转换为BufferedImage
    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

}

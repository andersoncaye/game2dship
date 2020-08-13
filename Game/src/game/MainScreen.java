package game;
import javax.swing.JFrame;
/* @author anderson.caye */
public class MainScreen extends JFrame implements Runnable{
    
    private int posXBall = 0;
    private int posYBall = 0;
    private int incX=  3;
    private int incY = 3;
    
    private int posXBar = 0;
    private int posYBar = 0;
    private int incBar = 19;
    
    public MainScreen() {
        initComponents();
        formComponentResized(null);
      
        this.posXBall = this.lbBall.getX();
        this.posYBall = this.lbBall.getY();
        
        this.posXBar = this.lbBed.getX();
        this.posYBar = this.lbBed.getY();
        
        new Thread(this).start();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBall = new javax.swing.JLabel();
        lbBed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                key(evt);
            }
        });

        lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sship64x64.png"))); // NOI18N

        lbBed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bar.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbBall)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(lbBed)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbBall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(lbBed)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void key(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_key
        if( evt.getKeyCode() == evt.VK_LEFT){
            this.posXBar += -incBar;
        }
        if( evt.getKeyCode() == evt.VK_RIGHT){
            this.posXBar += incBar;
        }
        if( evt.getKeyCode() == evt.VK_UP){
            this.posYBar += -incBar;
        }
        if( evt.getKeyCode() == evt.VK_DOWN){
            this.posYBar += incBar;
        }
        this.lbBed.setLocation(posXBar, posYBar);
    }//GEN-LAST:event_key

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBall;
    private javax.swing.JLabel lbBed;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            while (true) {

                this.posXBall += this.incX;
                this.posYBall += this.incY;

                if (this.posXBall + this.lbBall.getWidth() > this.getWidth()) {
                    this.incX = -3;
                    System.out.println("<");
                    this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Oship64x64.png")));
                }
                if (this.posXBall < 0) {
                    incX = 3;
                    System.out.println(">");
                    this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Lship64x64.png")));
                }

                if (this.posYBall + this.lbBall.getHeight() > this.getHeight()) {
                    this.incY = -3;
                    System.out.println("^");
                    this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Nship64x64.png")));
                }
                if (this.posYBall < 0) {
                    incY = 3;
                    System.out.println("V");
                    this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sship64x64.png")));
                }

                if (this.posYBall + this.lbBall.getHeight() > this.posYBar &&
                    this.posYBall + this.lbBall.getHeight() < this.posYBar + this.lbBed.getHeight()&&
                    this.posXBall + this.lbBall.getWidth()> this.posXBar &&
                    this.posXBall + this.lbBall.getWidth() < this.posXBar + this.lbBed.getWidth()) {
                    if (this.posXBall > this.posXBar){
                        System.out.println("V Bara");
                        this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sship64x64.png")));
                    }
                    if (this.posXBall < this.posXBar){
                        System.out.println("^ Bara");
                        this.lbBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Nship64x64.png")));
                    }
                    incX = incX * -1;
                    incY = incY * -1;

                }

                this.lbBall.setLocation(posXBall, posYBall);

                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

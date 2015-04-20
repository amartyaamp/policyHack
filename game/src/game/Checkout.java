/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Kapil Thakkar
 */
public class Checkout extends javax.swing.JFrame
{

    /**
     * Creates new form Checkout
     */
    public Checkout()
    {
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        calculateFinalScore();

        tipsLabel.setText(generateTips());

        nameLabel.setText(Globals.name);
        scoreLabel.setText(Integer.toString(Globals.score) + " out of " + Integer.toString(Globals.productList.size() * 100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        tipsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Hello");

        nameLabel.setText("name");

        jLabel2.setText("Your Score is:");

        scoreLabel.setText("score");

        tipsLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(scoreLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nameLabel))
                            .addComponent(tipsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(exitButton)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(scoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitButtonActionPerformed
    {//GEN-HEADEREND:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel tipsLabel;
    // End of variables declaration//GEN-END:variables

    private void calculateFinalScore()
    {
        for (Product cart : Globals.cart)
        {
            Globals.score += 100;
            Globals.availableMoney -= cart.sellingPrice;
            Globals.score -= cart.getValueToDeduct();
        }
    }

    private String generateTips()
    {
        String tips = "<html>";

        if (Globals.score > Globals.productList.size() * 100 -50)
        {
            tips += "Excellent..! You are a very Good consumer";
        }
        else
        {
            tips+="You need to pay more attention while shopping...!<br><br>";
            tips += "Some general tips:<br>";
            if (Globals.cart.size() < Globals.productList.size())
            {
                tips += "You must hurry up! You missed some of the products<br>";
            }
            for (Product cart : Globals.cart)
            {
                if (cart.isIsExpired())
                {
                    tips += "You purchased " + cart.getName() + " which has been expired.. <br>Please Do not forget to check expirey date next time<br>";
                }
                if (cart.getLogo().contains("fake"))
                {
                    tips += "The product " + cart.getName() + " selected by you has a fake logo, Please be aware of duplicates<br>";
                }
                if (cart.getSellingPrice() > cart.getPrice())
                {
                    tips += "You ovrpaid for the product " + cart.getName() + " , <br>Please make sure that you check MRP before paying to shop-keeper<br>";
                }
            }
            tips += "<b>General Tip:</b>Try to see for agmark or ISI or fssai logo (given by Government) on the product and the nutrition value. ";
        }

        tips += "</html>";
        return tips;
    }
}
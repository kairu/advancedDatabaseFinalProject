
import dbConn.oraDBCredentials;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class adminForm extends javax.swing.JFrame {
    oraDBCredentials db = new oraDBCredentials();
    /**
     * Creates new form adminForm
     */
    public adminForm() throws SQLException {
        initComponents();
        this.setTitle("Administrator Window");
        this.getContentPane().setBackground(new Color(251,227,215));
        this.setLocationRelativeTo(null);
        cmbUsers();
        showPieChart();
        showLineChart();
        //showHistogram();
        showBarChart();
        db.conn.close();
        PromptSupport.setPrompt("Enter New Password", txt_pass);
    }
    
    void cmbUsers() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT user_id FROM login");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cmb_users.addItem(rs.getString("user_id"));
        }
    }
    
    public void showPieChart() throws SQLException{
        //create dataset
         db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM %s "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST ",cmb_subjects.getSelectedItem());
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        while(rs.next()){
            barDataset.setValue(rs.getString("user_id"),rs.getInt("points"));
        }
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart(cmb_subjects.getSelectedItem() + " Points",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       ps = db.conn.prepareStatement(sql);
       rs = ps.executeQuery();
       while(rs.next()){
           piePlot.setSectionPaint(rs.getString("user_id"),new Color(randomColors(),randomColors(),randomColors()));
       }      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pnl_pie.removeAll();
        pnl_pie.add(barChartPanel, BorderLayout.CENTER);
        pnl_pie.validate();
    }
    int randomColors(){
        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(255);
        return randomNumber;
    }
    public void showLineChart() throws SQLException{
         db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //English
        String sql = String.format("SELECT e.points, 'English' AS TableName "
                + "FROM "
                + "( "
                + "SELECT account_id, user_id "
                + "FROM login "
                + ") l "
                + "INNER JOIN english e on e.account_id = l.account_id "
                + "WHERE l.user_id = '%s'",cmb_users.getSelectedItem());
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dataset.setValue(rs.getInt("points"), "points", rs.getString("TableName"));
        }
        
        //Geography
        sql = String.format("SELECT g.points, 'Geography' AS TableName "
                + "FROM "
                + "( "
                + "SELECT account_id, user_id "
                + "FROM login "
                + ") l "
                + "INNER JOIN geography g on g.account_id = l.account_id "
                + "WHERE l.user_id = '%s'",cmb_users.getSelectedItem());
        ps = db.conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            dataset.setValue(rs.getInt("points"), "points", rs.getString("TableName"));
        }
        
        //Math
        sql = String.format("SELECT m.points, 'Math' AS TableName "
                + "FROM "
                + "( "
                + "SELECT account_id, user_id "
                + "FROM login "
                + ") l "
                + "INNER JOIN math m on m.account_id = l.account_id "
                + "WHERE l.user_id = '%s'",cmb_users.getSelectedItem());
        ps = db.conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            dataset.setValue(rs.getInt("points"), "points", rs.getString("TableName"));
        }
        
        //MUSICARTS
        sql = String.format("SELECT m.points, 'MusicArts' AS TableName "
                + "FROM "
                + "( "
                + "SELECT account_id, user_id "
                + "FROM login "
                + ") l "
                + "INNER JOIN musicarts m on m.account_id = l.account_id "
                + "WHERE l.user_id = '%s'",cmb_users.getSelectedItem());
        ps = db.conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            dataset.setValue(rs.getInt("points"), "points", rs.getString("TableName"));
        }
        
        //Science
        sql = String.format("SELECT s.points, 'Science' AS TableName "
                + "FROM "
                + "( "
                + "SELECT account_id, user_id "
                + "FROM login "
                + ") l "
                + "INNER JOIN science s on s.account_id = l.account_id "
                + "WHERE l.user_id = '%s'",cmb_users.getSelectedItem());
        ps = db.conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            dataset.setValue(rs.getInt("points"), "points", rs.getString("TableName"));
        }
       
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart(cmb_users.getSelectedItem().toString(),"Subject","points", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        pnl_line.removeAll();
        pnl_line.add(lineChartPanel, BorderLayout.CENTER);
        pnl_line.validate();
    }
    /*public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
        JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
        XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        pnl_histo.removeAll();
        pnl_histo.add(barpChartPanel2, BorderLayout.CENTER);
        pnl_histo.validate();
    }*/
    public void showBarChart() throws SQLException{
         db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT user_id, logincount "
                + "FROM LOGIN");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while(rs.next()){
            dataset.setValue(rs.getInt("logincount"),"login",rs.getString("user_id"));
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Number of Logins","users","count", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer;
        renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        pnl_bar.removeAll();
        pnl_bar.add(barpChartPanel, BorderLayout.CENTER);
        pnl_bar.validate();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_pie = new javax.swing.JPanel();
        pnl_line = new javax.swing.JPanel();
        pnl_bar = new javax.swing.JPanel();
        cmb_subjects = new javax.swing.JComboBox<>();
        cmb_users = new javax.swing.JComboBox<>();
        txt_User = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1206, 645));

        pnl_pie.setBackground(new java.awt.Color(0, 102, 255));
        pnl_pie.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_pie.setMaximumSize(new java.awt.Dimension(566, 199));
        pnl_pie.setLayout(new java.awt.BorderLayout());

        pnl_line.setBackground(new java.awt.Color(0, 102, 255));
        pnl_line.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_line.setMaximumSize(new java.awt.Dimension(566, 199));
        pnl_line.setPreferredSize(new java.awt.Dimension(566, 199));
        pnl_line.setLayout(new java.awt.BorderLayout());

        pnl_bar.setBackground(new java.awt.Color(0, 102, 255));
        pnl_bar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_bar.setMaximumSize(new java.awt.Dimension(566, 199));
        pnl_bar.setPreferredSize(new java.awt.Dimension(566, 199));
        pnl_bar.setLayout(new java.awt.BorderLayout());

        cmb_subjects.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Math", "Geography", "Science", "MusicArts" }));
        cmb_subjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_subjectsMouseClicked(evt);
            }
        });
        cmb_subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_subjectsActionPerformed(evt);
            }
        });

        cmb_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_usersMouseClicked(evt);
            }
        });
        cmb_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_usersActionPerformed(evt);
            }
        });

        txt_User.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_User.setText("User");
        txt_User.setEnabled(false);

        jLabel1.setText("User ID:");

        jLabel2.setText("New Password:");

        btn_submit.setText("Change Password");
        btn_submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_submitMouseClicked(evt);
            }
        });

        btn_print.setText("Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb_users, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl_pie, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(pnl_line, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_pass))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_User, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btn_submit)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(btn_print)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(cmb_subjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_pie, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(cmb_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_line, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_submit)))
                .addGap(62, 62, 62)
                .addComponent(btn_print)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_subjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_subjectsMouseClicked
        
    }//GEN-LAST:event_cmb_subjectsMouseClicked

    private void cmb_subjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_subjectsActionPerformed
        try {
            // TODO add your handling code here:
            showPieChart();
        } catch (SQLException ex) {
            Logger.getLogger(adminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_subjectsActionPerformed

    private void cmb_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_usersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_usersMouseClicked

    private void cmb_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_usersActionPerformed
        try {
            // TODO add your handling code here:
            txt_User.setText(cmb_users.getSelectedItem().toString());
            showLineChart();
        } catch (SQLException ex) {
            Logger.getLogger(adminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_usersActionPerformed

    private void btn_submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submitMouseClicked
        try {
            // TODO add your handling code here:
            updatePassword();
        } catch (SQLException ex) {
            Logger.getLogger(adminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_submitMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new PrintResult(this), postformat);
            if (pjob.printDialog()) {
                try{
                pjob.print();
                }catch(Exception e){
                    System.out.print("Error: " + e);
                }
            }
        } 
    }//GEN-LAST:event_btn_printMouseClicked
    void updatePassword() throws SQLException{
        
        String user = txt_User.getText();
        String pass = txt_pass.getText();
        String sql = String.format("UPDATE login "
                    + "SET user_pass='%s'"
                    + "WHERE user_id='%s'", pass, user);
        db.stmt = db.conn.createStatement();
        db.stmt.executeUpdate(sql);
        db.conn.close();
        JOptionPane.showMessageDialog(null,"Password has been changed!");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new adminForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(adminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cmb_subjects;
    private javax.swing.JComboBox<String> cmb_users;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnl_bar;
    private javax.swing.JPanel pnl_line;
    private javax.swing.JPanel pnl_pie;
    private javax.swing.JTextField txt_User;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}

class PrintResult implements Printable {
    final Component comp;

    public PrintResult(Component comp){
        this.comp = comp;
    }

    @Override
    public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }
}

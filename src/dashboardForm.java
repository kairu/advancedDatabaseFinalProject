
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fontPackage.fontStyles;
import roundedFields.roundedPanel;
import images.imageNames;
import dbConn.oraDBCredentials;
import colors.colors;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class dashboardForm extends javax.swing.JFrame {
    oraDBCredentials db = new oraDBCredentials();
    //loginForm login = new loginForm();
    /**
     * Creates new form dashboardForm
     * @throws java.awt.FontFormatException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public dashboardForm() throws FontFormatException, IOException, SQLException {
        initComponents();
        btn_admin.setVisible(false);
        this.getContentPane().setBackground(new Color(251,227,215));
        this.setTitle("Dashboard");
        this.setLocationRelativeTo(null);
        setTextDesigns();
        setImages();
        showLeaderboards();
    }
    
    @Override
    public void setName(String name){
        lbl_Name.setText("Welcome, "+name);
    }
    public void setPoints(int points){
        lbl_points.setText("Total points: " +String.valueOf(points));
    }
    public void isAdmin(int state){
        if(state == 0){
            btn_admin.setVisible(true);
        }
    }
    private void showMath() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM MATH "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
    private void showGeography() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM GEOGRAPHY "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
    private void showEnglish() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM ENGLISH "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
    private void showMusicArts() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM MUSICARTS "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
    private void showScience() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT l.user_id,points AS points "
                + "FROM "
                + "( "
                + "SELECT account_id, points AS points "
                + "FROM SCIENCE "
                + ") t "
                + "INNER JOIN login l on l.account_id = t.account_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
        
    private void showLeaderboards() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        
        String sql = String.format("SELECT l.user_id, SUM(points) as points "
                + "FROM "
                + "( "
                + "SELECT account_id,points AS points "
                + "FROM ENGLISH "
                + "UNION ALL "
                + "SELECT account_id,points "
                + "FROM MATH "
                + "UNION ALL "
                + "SELECT account_id,points "
                + "FROM GEOGRAPHY "
                + "UNION ALL "
                + "SELECT account_id,points "
                + "FROM MUSICARTS "
                + "UNION ALL "
                + "SELECT account_id,points "
                + "FROM SCIENCE "
                + ")t "
                + "INNER JOIN LOGIN l on l.account_id = t.account_id "
                + "GROUP BY l.user_id "
                + "ORDER BY points DESC NULLS LAST");
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel) tbl_leaderboards.getModel();
                tm.setRowCount(0);
                while(rs.next()){
                    Object row[]={
                        rs.getString("user_id"),
                        rs.getInt("points"),
                    };
                    tm.addRow(row);
                }
            db.conn.close();
    }
    
    final void setTextDesigns() throws FontFormatException, IOException, IOException{
        lbl_Name.setFont(fontStyles.setMaely(56));
        
        btn_leadScience.setFont(fontStyles.setMaely(14));
        btn_leadMusicArts.setFont(fontStyles.setMaely(14));
        btn_leadEnglish.setFont(fontStyles.setMaely(14));
        btn_leadGeography.setFont(fontStyles.setMaely(14));
        btn_leadMath.setFont(fontStyles.setMaely(14));
        btn_leadOverall.setFont(fontStyles.setMaely(14));
        
        lbl_leaderboard.setFont(fontStyles.setMaely(24));
        btn_signOut.setFont(fontStyles.setMaely(24));
        lbl_points.setFont(fontStyles.setMaely(24));
        lbl_leaderboardType.setFont(fontStyles.setMaely(18));
        
        lbl_readyQuiz.setFont(fontStyles.setMaely(36));
        btn_Science.setFont(fontStyles.setMaely(36));
        btn_Math.setFont(fontStyles.setMaely(36));
        btn_English.setFont(fontStyles.setMaely(36));
        btn_Geography.setFont(fontStyles.setMaely(36));
        btn_MusicArts.setFont(fontStyles.setMaely(36));
    }
    
    final void setImages(){
        lbl_asteriskImg1.setIcon(imageNames.getImage(lbl_asteriskImg1.getWidth(),lbl_asteriskImg1.getHeight(),"*"));
        lbl_asteriskImg2.setIcon(imageNames.getImage(lbl_asteriskImg2.getWidth(),lbl_asteriskImg2.getHeight(),"*"));
        lbl_doubleLoopImg1.setIcon(imageNames.getImage(lbl_doubleLoopImg1.getWidth(),lbl_doubleLoopImg1.getHeight(),"double"));
        lbl_doubleLoopImg2.setIcon(imageNames.getImage(lbl_doubleLoopImg2.getWidth(),lbl_doubleLoopImg2.getHeight(),"double"));
        lbl_lightbulb.setIcon(imageNames.getImage(lbl_lightbulb.getWidth(),lbl_lightbulb.getHeight(),"bulb"));
        lbl_Owl.setIcon(imageNames.getImage(lbl_Owl.getWidth(),lbl_Owl.getHeight(),"owl"));
        
        lbl_lightbulb.setText(null);
        lbl_Owl.setText(null);
        lbl_asteriskImg1.setText(null);
        lbl_asteriskImg2.setText(null);
        lbl_doubleLoopImg1.setText(null);
        lbl_doubleLoopImg2.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new roundedPanel(15);//javax.swing.JPanel();
        lbl_Name = new javax.swing.JLabel();
        btn_signOut = new javax.swing.JButton();
        lbl_points = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_leadScience = new javax.swing.JButton();
        btn_leadMath = new javax.swing.JButton();
        btn_leadEnglish = new javax.swing.JButton();
        btn_leadGeography = new javax.swing.JButton();
        btn_leadMusicArts = new javax.swing.JButton();
        btn_leadOverall = new javax.swing.JButton();
        lbl_leaderboardType = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_leaderboards = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_readyQuiz = new javax.swing.JLabel();
        btn_Science = new javax.swing.JButton();
        btn_Math = new javax.swing.JButton();
        btn_English = new javax.swing.JButton();
        btn_Geography = new javax.swing.JButton();
        btn_MusicArts = new javax.swing.JButton();
        lbl_doubleLoopImg1 = new javax.swing.JLabel();
        lbl_leaderboard = new javax.swing.JLabel();
        lbl_lightbulb = new javax.swing.JLabel();
        lbl_Owl = new javax.swing.JLabel();
        lbl_asteriskImg2 = new javax.swing.JLabel();
        lbl_asteriskImg1 = new javax.swing.JLabel();
        lbl_doubleLoopImg2 = new javax.swing.JLabel();
        btn_admin = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Name.setFont(new java.awt.Font("Tahoma", 0, 56)); // NOI18N
        lbl_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Name.setText("Welcome, Name!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_signOut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_signOut.setText("Sign Out");
        btn_signOut.setBorderPainted(false);
        btn_signOut.setContentAreaFilled(false);
        btn_signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_signOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_signOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_signOutMouseExited(evt);
            }
        });

        lbl_points.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_points.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_points.setText("Total Points:");
        lbl_points.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel3.setBackground(new java.awt.Color(124, 246, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_leadScience.setBackground(new java.awt.Color(253, 186, 237));
        btn_leadScience.setText("Science");
        btn_leadScience.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadScienceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadScienceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadScienceMouseExited(evt);
            }
        });

        btn_leadMath.setBackground(new java.awt.Color(255, 247, 209));
        btn_leadMath.setText("Math");
        btn_leadMath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadMathMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadMathMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadMathMouseExited(evt);
            }
        });

        btn_leadEnglish.setBackground(new java.awt.Color(255, 212, 131));
        btn_leadEnglish.setText("English");
        btn_leadEnglish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadEnglishMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadEnglishMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadEnglishMouseExited(evt);
            }
        });

        btn_leadGeography.setBackground(new java.awt.Color(245, 126, 154));
        btn_leadGeography.setText("Geography");
        btn_leadGeography.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadGeographyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadGeographyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadGeographyMouseExited(evt);
            }
        });

        btn_leadMusicArts.setBackground(new java.awt.Color(168, 135, 157));
        btn_leadMusicArts.setText("Music & Arts");
        btn_leadMusicArts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadMusicArtsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadMusicArtsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadMusicArtsMouseExited(evt);
            }
        });

        btn_leadOverall.setText("Overall");
        btn_leadOverall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_leadOverallMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_leadOverallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_leadOverallMouseExited(evt);
            }
        });

        lbl_leaderboardType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_leaderboardType.setText("Overall:");

        tbl_leaderboards.setBackground(new java.awt.Color(124, 246, 243));
        tbl_leaderboards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player Name", "Points"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_leaderboards.setEnabled(false);
        tbl_leaderboards.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_leaderboards);
        if (tbl_leaderboards.getColumnModel().getColumnCount() > 0) {
            tbl_leaderboards.getColumnModel().getColumn(0).setResizable(false);
            tbl_leaderboards.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_leadScience)
                            .addComponent(btn_leadEnglish)
                            .addComponent(btn_leadMath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_leadOverall)
                            .addComponent(btn_leadGeography)
                            .addComponent(btn_leadMusicArts)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lbl_leaderboardType)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_leadScience)
                    .addComponent(btn_leadMusicArts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_leadEnglish)
                    .addComponent(btn_leadGeography))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_leadMath)
                    .addComponent(btn_leadOverall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_leaderboardType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(251, 227, 215));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 400));

        lbl_readyQuiz.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_readyQuiz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_readyQuiz.setText("Are you ready Quizmate?");

        btn_Science.setBackground(new java.awt.Color(253, 186, 237));
        btn_Science.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Science.setText("Science");
        btn_Science.setToolTipText("");
        btn_Science.setBorder(null);
        btn_Science.setBorderPainted(false);
        btn_Science.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Science.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ScienceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ScienceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ScienceMouseExited(evt);
            }
        });

        btn_Math.setBackground(new java.awt.Color(255, 247, 209));
        btn_Math.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Math.setText("Mathematics");
        btn_Math.setBorder(null);
        btn_Math.setBorderPainted(false);
        btn_Math.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MathMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_MathMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_MathMouseExited(evt);
            }
        });

        btn_English.setBackground(new java.awt.Color(255, 212, 131));
        btn_English.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_English.setText("English");
        btn_English.setBorder(null);
        btn_English.setBorderPainted(false);
        btn_English.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EnglishMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_EnglishMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_EnglishMouseExited(evt);
            }
        });

        btn_Geography.setBackground(new java.awt.Color(245, 126, 154));
        btn_Geography.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Geography.setText("Geography");
        btn_Geography.setBorder(null);
        btn_Geography.setBorderPainted(false);
        btn_Geography.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GeographyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_GeographyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GeographyMouseExited(evt);
            }
        });

        btn_MusicArts.setBackground(new java.awt.Color(168, 135, 157));
        btn_MusicArts.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_MusicArts.setText("Music & Arts");
        btn_MusicArts.setBorder(null);
        btn_MusicArts.setBorderPainted(false);
        btn_MusicArts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MusicArtsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_MusicArtsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_MusicArtsMouseExited(evt);
            }
        });

        lbl_doubleLoopImg1.setText("DoubleLoop Image");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_readyQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_English, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_Science, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_Geography, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_Math, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(86, 86, 86)))
                            .addComponent(btn_MusicArts, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(lbl_doubleLoopImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(332, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_readyQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btn_Science, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btn_Math, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_English, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Geography, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_MusicArts, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(lbl_doubleLoopImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(288, Short.MAX_VALUE)))
        );

        lbl_leaderboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_leaderboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_leaderboard.setText("Leaderboards");

        lbl_lightbulb.setBackground(new java.awt.Color(255, 255, 255));
        lbl_lightbulb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_lightbulb.setText("lightbulb Image");

        lbl_Owl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Owl.setText("Owl Image");

        lbl_asteriskImg2.setText("asterisk Image");

        lbl_asteriskImg1.setText("asterisk Image");

        lbl_doubleLoopImg2.setText("DoubleLoop Image");

        btn_admin.setText("Administrator");
        btn_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_adminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lbl_lightbulb, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_leaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_asteriskImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_admin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_points, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_signOut)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(lbl_doubleLoopImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(245, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Owl, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(786, Short.MAX_VALUE)
                    .addComponent(lbl_asteriskImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(365, 365, 365)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_signOut)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lbl_points, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl_doubleLoopImg2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_asteriskImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_leaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lbl_Owl, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_lightbulb, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_admin)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(lbl_asteriskImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(448, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ScienceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ScienceMouseEntered
        // TODO add your handling code here:
        btn_Science.setForeground(colors.violet);
    }//GEN-LAST:event_btn_ScienceMouseEntered

    private void btn_ScienceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ScienceMouseExited
        // TODO add your handling code here:
        btn_Science.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_ScienceMouseExited

    private void btn_MathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MathMouseEntered
        // TODO add your handling code here:
        btn_Math.setForeground(colors.violet);
    }//GEN-LAST:event_btn_MathMouseEntered

    private void btn_MathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MathMouseExited
        // TODO add your handling code here:
        btn_Math.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_MathMouseExited

    private void btn_EnglishMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EnglishMouseEntered
        // TODO add your handling code here:
        btn_English.setForeground(colors.violet);
    }//GEN-LAST:event_btn_EnglishMouseEntered

    private void btn_EnglishMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EnglishMouseExited
        // TODO add your handling code here:
        btn_English.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_EnglishMouseExited

    private void btn_GeographyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GeographyMouseEntered
        // TODO add your handling code here:
        btn_Geography.setForeground(colors.violet);
    }//GEN-LAST:event_btn_GeographyMouseEntered

    private void btn_GeographyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GeographyMouseExited
        // TODO add your handling code here:
        btn_Geography.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_GeographyMouseExited

    private void btn_MusicArtsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MusicArtsMouseEntered
        // TODO add your handling code here:
        btn_MusicArts.setForeground(colors.violet);
    }//GEN-LAST:event_btn_MusicArtsMouseEntered

    private void btn_MusicArtsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MusicArtsMouseExited
        // TODO add your handling code here:
        btn_MusicArts.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_MusicArtsMouseExited

    private void btn_signOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signOutMouseEntered
        // TODO add your handling code here:
        btn_signOut.setForeground(Color.RED);
    }//GEN-LAST:event_btn_signOutMouseEntered

    private void btn_signOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signOutMouseExited
        // TODO add your handling code here:
        btn_signOut.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_signOutMouseExited

    private void btn_signOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signOutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        try {
            new loginForm().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_signOutMouseClicked

    private void btn_ScienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ScienceMouseClicked
        try {
            // TODO add your handling code here:
            subject("Science");
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ScienceMouseClicked

    private void btn_MathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MathMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            subject("Math");
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_MathMouseClicked

    private void btn_EnglishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EnglishMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            subject("English");
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_EnglishMouseClicked

    private void btn_GeographyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GeographyMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            subject("Geography");
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_GeographyMouseClicked

    private void btn_MusicArtsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MusicArtsMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            subject("MusicArts");
        } catch (FontFormatException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_MusicArtsMouseClicked

    private void btn_leadScienceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadScienceMouseEntered
        // TODO add your handling code here:
        btn_leadScience.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadScienceMouseEntered

    private void btn_leadScienceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadScienceMouseExited
        // TODO add your handling code here:
        btn_leadScience.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadScienceMouseExited

    private void btn_leadMusicArtsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMusicArtsMouseEntered
        // TODO add your handling code here:
        btn_leadMusicArts.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadMusicArtsMouseEntered

    private void btn_leadMusicArtsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMusicArtsMouseExited
        // TODO add your handling code here:
        btn_leadMusicArts.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadMusicArtsMouseExited

    private void btn_leadEnglishMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadEnglishMouseEntered
        // TODO add your handling code here:
        btn_leadEnglish.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadEnglishMouseEntered

    private void btn_leadEnglishMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadEnglishMouseExited
        // TODO add your handling code here:
        btn_leadEnglish.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadEnglishMouseExited

    private void btn_leadGeographyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadGeographyMouseEntered
        // TODO add your handling code here:
        btn_leadGeography.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadGeographyMouseEntered

    private void btn_leadGeographyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadGeographyMouseExited
        // TODO add your handling code here:
        btn_leadGeography.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadGeographyMouseExited

    private void btn_leadMathMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMathMouseEntered
        // TODO add your handling code here:
        btn_leadMath.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadMathMouseEntered

    private void btn_leadMathMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMathMouseExited
        // TODO add your handling code here:
        btn_leadMath.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadMathMouseExited

    private void btn_leadOverallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadOverallMouseEntered
        // TODO add your handling code here:
        btn_leadOverall.setForeground(colors.violet);
    }//GEN-LAST:event_btn_leadOverallMouseEntered

    private void btn_leadOverallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadOverallMouseExited
        // TODO add your handling code here:
        btn_leadOverall.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_leadOverallMouseExited

    private void btn_leadOverallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadOverallMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Overall: ");
            showLeaderboards();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadOverallMouseClicked

    private void btn_leadScienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadScienceMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Science: ");
            showScience();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadScienceMouseClicked

    private void btn_leadMusicArtsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMusicArtsMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Music & Arts: ");
            showMusicArts();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadMusicArtsMouseClicked

    private void btn_leadEnglishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadEnglishMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Engish: ");
            showEnglish();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadEnglishMouseClicked

    private void btn_leadGeographyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadGeographyMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Geography: ");
            showGeography();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadGeographyMouseClicked

    private void btn_leadMathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_leadMathMouseClicked
        try {
            // TODO add your handling code here:
            lbl_leaderboardType.setText("Math: ");
            showMath();
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_leadMathMouseClicked

    private void btn_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_adminMouseClicked
        try {
            // TODO add your handling code here:
            new adminForm().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_adminMouseClicked
    
    private void subject(String subj) throws FontFormatException, IOException, SQLException{
        int acc_id = getID();
        this.dispose();
        difficultyForm diff = new difficultyForm(subj,acc_id);
        //diff.subject = subj;
        //diff.setSubject(subj);
        diff.setVisible(true);
        //new difficultyForm().setVisible(true);
    }
    int getID() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        String sql = String.format("SELECT ACCOUNT_ID from LOGIN where user_id = '%s'",lbl_Name.getText().substring(9));
        PreparedStatement ps = db.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int accID = rs.getInt(1);
        return accID;
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
            java.util.logging.Logger.getLogger(dashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new dashboardForm().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(dashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_English;
    private javax.swing.JButton btn_Geography;
    private javax.swing.JButton btn_Math;
    private javax.swing.JButton btn_MusicArts;
    private javax.swing.JButton btn_Science;
    private javax.swing.JButton btn_admin;
    private javax.swing.JButton btn_leadEnglish;
    private javax.swing.JButton btn_leadGeography;
    private javax.swing.JButton btn_leadMath;
    private javax.swing.JButton btn_leadMusicArts;
    private javax.swing.JButton btn_leadOverall;
    private javax.swing.JButton btn_leadScience;
    private javax.swing.JButton btn_signOut;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Owl;
    private javax.swing.JLabel lbl_asteriskImg1;
    private javax.swing.JLabel lbl_asteriskImg2;
    private javax.swing.JLabel lbl_doubleLoopImg1;
    private javax.swing.JLabel lbl_doubleLoopImg2;
    private javax.swing.JLabel lbl_leaderboard;
    private javax.swing.JLabel lbl_leaderboardType;
    private javax.swing.JLabel lbl_lightbulb;
    private javax.swing.JLabel lbl_points;
    private javax.swing.JLabel lbl_readyQuiz;
    private javax.swing.JTable tbl_leaderboards;
    // End of variables declaration//GEN-END:variables
}

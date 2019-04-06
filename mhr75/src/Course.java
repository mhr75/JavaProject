
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nizamul
 */
public class Course extends javax.swing.JFrame implements Serializable {

    /**
     * Creates new form Course
     */
    static Socket s;
    static ObjectInputStream dis;
    static ObjectOutputStream dos;
    //Connection con;
    int id;

    public Course(int a, Socket aa, ObjectInputStream b, ObjectOutputStream c) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mechaaboo.png")));
        setTitle("Course Taking Tab");
        id = a;
        s = aa;
        dis = b;
        dos = c;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    dos.writeObject("404");
                    dos.flush();
                    e.getWindow().dispose();
                } catch (Exception ee) {

                }
                System.exit(0);
            }
        });
        initComponents();
        setLocationRelativeTo(null);
        //  createConnection();
        try {
            Show_course_in_Jtable();
        } catch (Exception e) {
          //  System.out.println("Jani na");
        }
    }

    public Course(Socket aa, ObjectInputStream b, ObjectOutputStream c) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        s = aa;
        dis = b;
        dos = c;
        setLocationRelativeTo(null);
        // createConnection();
        try {
            Show_course_in_Jtable();
        } catch (Exception e) {
          //  System.out.println("Jani na");
        }
    }

    public void ShowItem(int index) throws SQLException {
        c_id.setText((getCourseList().get(index).c_id()));
        cc_id.setText((getCourseList().get(index).cc_id()));
        dname.setText((getCourseList().get(index).c_d()));

        // txt_name.setText(getStudentList().get(index).getName());
        // txt_id.setText(getStudentList().get(index).getId());
        // txt_sem.setText(Integer.toString(getStudentList().get(index).getSemester()));
        // txt_cgpa.setText(Double.toString(getStudentList().get(index).getCgpa()));
        // lbl_image.setIcon(ResizeImage(null,getStudentList().get(index).getImage()));
    }

    public ArrayList<cours> getCourseList() throws SQLException {
        try {
            ArrayList<cours> stlist = new ArrayList<cours>();
            dos.writeObject("17");
            dos.flush();
            stlist = (ArrayList<cours>) dis.readObject();
            return stlist;
        } catch (Exception e) {

        }
        return null;
    }

    public void Show_course_in_Jtable() throws SQLException {
        ArrayList<cours> list = getCourseList();
        DefaultTableModel model = (DefaultTableModel) JTable_Course.getModel();
        model.setRowCount(0);
        Object[] row = new Object[1];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).c_id();
            model.addRow(row);
        }
    }

    void showNone() {
        c_id.setText("");
        cc_id.setText("");
        dname.setText("");
        // c_c.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cc_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        dname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LogIn = new javax.swing.JButton();
        LogIn3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Course = new javax.swing.JTable();
        LogIn4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 0)), "Course Add/Drop\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        cc_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Department:");

        c_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        c_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_idActionPerformed(evt);
            }
        });

        dname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Course Details:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Course_id:");

        LogIn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        LogIn.setText("Add");
        LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInActionPerformed(evt);
            }
        });

        LogIn3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        LogIn3.setText("Drop");
        LogIn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn3ActionPerformed(evt);
            }
        });

        JTable_Course.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JTable_Course.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Course List"
            }
        ));
        JTable_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_CourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Course);

        LogIn4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogIn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back1.png"))); // NOI18N
        LogIn4.setText("Back");
        LogIn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dname, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogIn4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogIn3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogIn)
                            .addComponent(LogIn3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(LogIn4)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_idActionPerformed

    private void LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInActionPerformed

        try {
            dos.writeObject("18");
            dos.flush();
            List l = new ArrayList<>();
            String pop[] = new String[2];
            //PreparedStatement pre =con.prepareStatement("insert into takes (s_id,c_id) values(?,?)"); 
            pop[0] = ("" + id);
            pop[1] = (c_id.getText());
            l.add(pop);
            dos.writeObject(l);
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "New course Added!");
            }
            showNone();
        } catch (Exception ex) {
         //   System.out.println("lol");
        }
    }//GEN-LAST:event_LogInActionPerformed

    private void LogIn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn3ActionPerformed
        // TODO add your handling code here:
        try {
            dos.writeObject("19");
            dos.flush();
            dos.writeObject(c_id.getText());
            dos.flush();
            String res = (String) dis.readObject();
            if (res.equals("true")) {
                JOptionPane.showMessageDialog(null, "Course Removed");
            }
            showNone();
        } catch (Exception e) {
            // System.out.println("not delete");
        }
    }//GEN-LAST:event_LogIn3ActionPerformed

    private void LogIn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Student(id, s, dis, dos).setVisible(true);
    }//GEN-LAST:event_LogIn4ActionPerformed

    private void JTable_CourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_CourseMouseClicked
        // TODO add your handling code here:

        int index = JTable_Course.getSelectedRow();
        try {
            ShowItem(index);
        } catch (Exception ex) {
            //Logger.getLogger(main_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JTable_CourseMouseClicked

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
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Course(s, dis, dos).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_Course;
    private javax.swing.JButton LogIn;
    private javax.swing.JButton LogIn3;
    private javax.swing.JButton LogIn4;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField cc_id;
    private javax.swing.JTextField dname;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

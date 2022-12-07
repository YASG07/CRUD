/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventana;

//importamos la clase del paquete con los metodo relacionados a la base de datos
import Clases.ConexionMySQL;
import static Clases.ConexionMySQL.con;
import static Clases.ConexionMySQL.st;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class VentanCRUD extends javax.swing.JFrame {
    
    //declaramos un modelo de tabla por defecto
    private DefaultTableModel Tabla;
    
    //creamos una instancia de dicha clase para acceder a los metodos de la clase
    ConexionMySQL CMSQL;
    /**
     * Creates new form VentanCRUD
     */
    public VentanCRUD() {
        initComponents();
    //inicializamos la instancia de la clase y ejecutamos su constructor iniciando la conexión con la base de datos
        CMSQL = new ConexionMySQL();
        //hacemos uso del metodo para visualizar los datos en la base de datos
        llenarTabla();
    }//constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnInsertar = new javax.swing.JButton();
        BtnConsultar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        TxtBanda = new javax.swing.JTextField();
        TxtAlbumD = new javax.swing.JTextField();
        TxtUAlbum = new javax.swing.JTextField();
        LblUAlbum = new javax.swing.JLabel();
        LblADebut = new javax.swing.JLabel();
        LblBanda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDiscografia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(130, 170, 180));
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        BtnInsertar.setText("Insertar");
        BtnInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertarActionPerformed(evt);
            }
        });

        BtnConsultar.setText("Consultar");
        BtnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("Actualizar");
        BtnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        LblUAlbum.setText("Ultimo Album:");

        LblADebut.setText("Album Debut:");

        LblBanda.setText("Banda:");

        TblDiscografia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Banda", "Album Debut", "Ultimo Album"
            }
        ));
        jScrollPane1.setViewportView(TblDiscografia);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtBanda, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(TxtAlbumD)
                            .addComponent(TxtUAlbum)
                            .addComponent(LblBanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblADebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblUAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(BtnConsultar)
                                .addGap(77, 77, 77)
                                .addComponent(BtnActualizar)
                                .addGap(52, 52, 52)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LblBanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblADebut)
                .addGap(4, 4, 4)
                .addComponent(TxtAlbumD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblUAlbum)
                .addGap(4, 4, 4)
                .addComponent(TxtUAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInsertar)
                    .addComponent(BtnConsultar)
                    .addComponent(BtnActualizar)
                    .addComponent(BtnEliminar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed
        reinicarLabels();
        if(TxtBanda.getText().equals("") || TxtAlbumD.getText().equals("") || TxtUAlbum.getText().equals("")){
            //Envia como mensaje que campos deben de rellenarse para completar la acción
            LblBanda.setText(LblBanda.getText() + " Campo requerido");
            LblADebut.setText(LblADebut.getText() + " Campo requerido");
            LblUAlbum.setText(LblUAlbum.getText() + " Campo requerido");
            //evita que se ejecute las siguiente lineas de codigo
            return;
    }//validación si algún campo esta vacío
    //haciendo uso de la instancia de la clase ejecutamos el metodo insercion con los parametros de las cajas de texto
        CMSQL.insercion(TxtBanda.getText(), TxtAlbumD.getText(), TxtUAlbum.getText(), this);
        //hacemos uso del metodo para vaciar la tabla para después recargarla
        vaciarTabla();
        //hacemos uso del metodo para visualizar los datos en la base de datos
        llenarTabla();
    }//GEN-LAST:event_BtnInsertarActionPerformed

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        reinicarLabels();
        if(TxtAlbumD.getText().equals("") || TxtUAlbum.getText().equals("")){
            //Envia como mensaje que campos deben de rellenarse para completar la acción
            LblADebut.setText(LblADebut.getText() + " Campo requerido");
            LblUAlbum.setText(LblUAlbum.getText() + " Campo requerido");
            //evita que se ejecute las siguiente lineas de codigo
            return;
    }//validación si algún campo esta vacío
    //haciendo uso de la instancia de la clase ejecutamos el metodo consulta con los parametros de las cajas de texto
        CMSQL.consulta(TxtAlbumD.getText(), TxtUAlbum.getText(), this);
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        reinicarLabels();
        if(TxtBanda.getText().equals("") || TxtUAlbum.getText().equals("")){
            //Envia como mensaje que campos deben de rellenarse para completar la acción
            LblBanda.setText(LblBanda.getText() + " Campo requerido");
            LblUAlbum.setText(LblUAlbum.getText() + " Campo requerido");
            //evita que se ejecute las siguiente lineas de codigo
            return;
    }//validación si algún campo esta vacío
    //haciendo uso de la instancia de la clase ejecutamos el metodo update con los parametros de las cajas de texto 
        CMSQL.update(TxtUAlbum.getText(), TxtBanda.getText(), this);
        //hacemos uso del metodo para vaciar la tabla para después recargarla
        vaciarTabla();
        //hacemos uso del metodo para visualizar los datos en la base de datos
        llenarTabla();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        reinicarLabels();
        if(TxtBanda.getText().equals("")){
            //Envia como mensaje que campos deben de rellenarse para completar la acción
            LblBanda.setText(LblBanda.getText() + " Campo requerido");
            //evita que se ejecute las siguiente lineas de codigo
            return;
    }//validación si algún campo esta vacío
    //haciendo uso de la instancia de la clase ejecutamos el metodo delete con los parametros de las cajas de texto
        CMSQL.delete(TxtBanda.getText(), this);
        //hacemos uso del metodo para vaciar la tabla para después recargarla
        vaciarTabla();
        //hacemos uso del metodo para visualizar los datos en la base de datos
        llenarTabla();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void llenarTabla(){
        //Inicializamos la tabla con un modelo
        Tabla = (DefaultTableModel) TblDiscografia.getModel();
        //arreglo para almacenar el resultado de cada campo
        Object [] row = new Object[4];
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            String query = "SELECT * FROM Banda";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                Tabla.addRow(row);
            }//ciclo while guarda los valores obtenidos de la consulta en las varibables que se muestran.
        } catch (SQLException ex) {
            showMessageDialog(this, "Error en "+ex);
            System.exit(EXIT_ON_CLOSE);
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
    }//metodo para llenar la tabla donde se visualizan los datos
    
    private void vaciarTabla(){
        //Inicializamos la tabla con un modelo
        Tabla = (DefaultTableModel) TblDiscografia.getModel();
        int i = 0;
        while(i < Tabla.getRowCount()){
            Tabla.removeRow(i);
        }//metodo while para remover los renglones de la tabla
    }//metodo para vaciar la tabla
    
    private void reinicarLabels(){
        //reestablecen las etiquetas
        LblBanda.setText("Banda:");
        LblADebut.setText("Album Debut:");
        LblUAlbum.setText("Ultimo Album;");
    }//metodo para devoler los valores por defecto de las etiquetas
    
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
            java.util.logging.Logger.getLogger(VentanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnConsultar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JLabel LblADebut;
    private javax.swing.JLabel LblBanda;
    private javax.swing.JLabel LblUAlbum;
    private javax.swing.JTable TblDiscografia;
    private javax.swing.JTextField TxtAlbumD;
    private javax.swing.JTextField TxtBanda;
    private javax.swing.JTextField TxtUAlbum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
//Importaciones para conectar con mysql
import java.net.Socket;
//Importamos el socket para combrobar la conexion

/**
 *
 * @author Lenovo
 */
public class ConexionMySQL {
    
    public static Connection con;
    public static Statement st;
    //paramtros a usar
    
    public ConexionMySQL(){
        try {
            //Nombre del driver para conectar MySQL con Java
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*Nombre del servidor, base de datos que se quiere emplear, 
            usuario y contraseña con la que se conecta al servidor*/
            con = DriverManager.getConnection("jdbc:mysql://localhost/DiscografiaPF","Yael","reze");
        } catch (ClassNotFoundException ex) {
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
            showMessageDialog(null, "Ocurrio un error inesperado "+ex);
            return;
        } catch (SQLException ex) {
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
            showMessageDialog(null, "Error al conectar \n"+ex);
            return;
        }
        showMessageDialog(null, "Conectado");
    }//metodo conectar a base de datos
    
    //Recibe como parametro el nombre de la banda junto con el de su primer y ultimo album
    public void insercion(String Nombre, String AlbumD, String AlbumU, JFrame JF){
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //Ejecuta la sentencia DML INSERT INTO con los parametros recibidos
            st.executeUpdate("INSERT INTO Banda (ID_Banda, Nom_Banda, Album_Debut, Album_Ultimo) " +
             "VALUES (DEFAULT, " + " '" + Nombre + "', '" + AlbumD + "', '" + AlbumU + "')"); 
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Ocurrio un error inesperado "+ex);
            return;
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        showMessageDialog(JF, "Registrado con éxito.");
    }//Registro
    
    //Recie dos parametros como filtro Nombre del album debut y del ultimo album de la banda a buscar
    public Object[] consulta(String AD, String AU, JFrame JF){
        Object Nombres [] = new Object [4];
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            String query = "SELECT * FROm Banda WHERE "
                    + "Album_Debut LIKE '" + AD + "%' AND Album_Ultimo LIKE '" + AU + "%'";
            //Ejecuta la sentencia SELECT con los parametros recibidos
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Nombres[0] = rs.getInt(1);
                Nombres[1] = rs.getString(2);
                Nombres[2] = rs.getString(3);
                Nombres[3] = rs.getString(4);
            }//ciclo while guarda los valores obtenidos de la consulta en las varibables que se muestran.
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Error en "+ex);
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        return Nombres;
    }//READ
    
    //recibe doss parametros el nombre del nuevo album y el nombre de la banda cuyo registrro será modificado
    public void update(String New_UAlbum, String Nombre, JFrame JF){
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //Ejecuta la sentencia DML UPDATE con los parametros recibidos
            st.executeUpdate("UPDATE Banda SET Album_Ultimo = '"+New_UAlbum+"' WHERE Nom_Banda = '" + Nombre + "'");
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Ocurrio un error inesperado "+ex);
            return;
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        showMessageDialog(JF, "Actualizado con éxito");
    }//UPDATE
    
    //recibe un unico parametro el nombre de la banda cuyo registro será borrado
    public void delete(String Nombre, JFrame JF){
        try {
            //inicializamos la variable de tipo statemente
            st = con.createStatement();
            //Ejecuta la sentencia DML DELETE con los parametros recibidos
            st.executeUpdate("DELETE FROM Banda WHERE Nom_Banda = '" + Nombre + "'");
        } catch (SQLException ex) {
            //El parametro JF se refiere a una ventana padre para lanzar el mensaje
            showMessageDialog(JF, "Ocurrio un error inesperado " + ex);
            return;
            //En caso de encontrar dicha excepción envia un mensaje y termina el bloque
        }//error en la sentencia SQL
        showMessageDialog(JF, "Eliminado con éxito");
    }//DELETE
    
    public String comprobarConexion(JFrame JF){
        String dir = "";
        int puerto = 3306;
        try {
            Socket s = new Socket(dir, puerto);
            if (s.isConnected()){
                return "Conectado";
            }//if
        } catch (IOException ex) {
            showMessageDialog(JF, "Error en: " + ex);
        }//cacth
        return "Desconectado";
    }//metodo para comprobar la conexión
    
}//clase

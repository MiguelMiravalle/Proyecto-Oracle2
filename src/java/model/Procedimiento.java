/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author conke
 */

import java.sql.CallableStatement;
import java.sql.Connection;
        
public class Procedimiento {
    public static void main(String args[])throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
        CallableStatement callate=con.prepareCall("{call guardar_alumno(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2, "Miguel");
        callate.setString(3, "Miravalle");
        
        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("El id ingresado es: "+pk);
    }
}

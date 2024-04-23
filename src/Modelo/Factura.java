/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author coromoro
 */
public class Factura {
    private int idFactura;
    private int totalFactura;
    private Date fechaFactura;
    private int idClienteFactura;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdClienteFactura() {
        return idClienteFactura;
    }

    public void setIdClienteFactura(int idClienteFactura) {
        this.idClienteFactura = idClienteFactura;
    }

    @Override
    public String toString() {
        return idFactura+"";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura other = (Factura) obj;
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }
    public Iterator<Factura>listar(){
        ArrayList<Factura> lasfacturas = new ArrayList<>();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Factura unaFactura;
            while (rs.next()){
                unaFactura = new Factura();
                unaFactura.setIdFactura(rs.getInt   ("idFactura"));
                unaFactura.setTotalFactura(rs.getInt("totalFactura"));
                unaFactura.setFechaFactura(rs.getDate("fechaFactura"));
                unaFactura.setIdClienteFactura(rs.getInt("idClienteFactura"));
                lasfacturas.add(unaFactura);
            }
        }catch (SQLException ex){
            System.err.println("Error al listar"+ex.getMessage());
        }
        return lasfacturas.iterator();
    }
    public int insertar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "
                    +this.getClass().getSimpleName()+" VALUES(NULL,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            sql.setInt(1, this.getTotalFactura());
            sql.setDate(2, this.getFechaFactura());
            sql.setInt(3, this.getIdClienteFactura());
            sql.execute();
            System.out.println(this.getClass().getSimpleName()+"insertado correctamente");
            ResultSet rs = sql.getGeneratedKeys();
            int ultimoID = 0;
            if (rs.next()) {
                        ultimoID = rs.getInt(1);
                        System.out.println("El último ID generado es: " + ultimoID);
                    } else {
                        System.out.println("No se pudo obtener el último ID generado");
                    }
           
            System.out.println("id factura "+ultimoID);
            return ultimoID;
        }catch(SQLException ex){
            System.err.println("error al insertar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return 0;
    }
    public void modificar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                    " SET totalFactura =?,fechaFactura =?,idClienteFactura =? WHERE idFactura =?");
            sql.setInt(1, this.getTotalFactura());
            sql.setDate(2, this.getFechaFactura());
            sql.setInt(3, this.getIdClienteFactura());
            sql.setInt(4, this.getIdFactura());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"modificado correctamente");
        }catch(SQLException ex){
            System.err.println("error al modificar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" DELETE FROM "
                    +this.getClass().getSimpleName()+" WHERE idFactura = ?");
            sql.setInt(1,getIdFactura());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("error al elimminar"+this .getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Factura> buscar (String busqueda){
        ArrayList<Factura> lasFacturas = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName()
            +" WHERE fechaFactura LIKE ? OR idClienteFactura LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            ResultSet rs =sql.executeQuery();
            Factura unaFactura;
            while (rs.next()){
                unaFactura=new Factura();
                unaFactura.setIdFactura(rs.getInt ("idFactura"));
                unaFactura.setTotalFactura(rs.getInt("totalFactura"));
                unaFactura.setFechaFactura(rs.getDate("fechaFactura"));
                unaFactura.setIdClienteFactura(rs.getInt("idClienteFactura"));
                lasFacturas.add(unaFactura);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar" +this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return lasFacturas.iterator();
    }
    public Factura buscarPorID (int elID){
        Factura unafactura=new Factura();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement(" SELECT * FROM "+
                    this.getClass().getSimpleName()+" WHERE idFactura = ? ");
            sql.setInt(1, elID);
            ResultSet rs =sql.executeQuery();
            while (rs.next()){
                unafactura.setIdFactura(rs.getInt("idProducto"));
                unafactura.setTotalFactura(rs.getInt("totalFactura"));
                unafactura.setFechaFactura(rs.getDate("fechaFactura"));
                unafactura.setIdClienteFactura(rs.getInt("idClienteFactura"));
            }
        }catch (SQLException ex){
            System.err.println("error al buscar el id"+ex.getMessage());
        }
        return unafactura;
    }
}


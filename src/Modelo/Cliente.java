/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author coromoro
 */
public class Cliente {
    
    private int    idCliente;
    private String nombreCliente;
    private String documentoCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    @Override
    public String toString() {
        return nombreCliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }
     public Iterator<Cliente>listar(){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                unCliente.setIdCliente(  rs.getInt   ("idCliente"));
                unCliente.setNombreCliente(   rs.getString ("nombreCliente"));
                unCliente.setDocumentoCliente( rs.getString ("documentoCliente"));
                losClientes.add(unCliente);
            }
        }catch (SQLException ex){
            System.err.println("Error al listar"+ex.getMessage());
        }
        if (losClientes.isEmpty()){
            Cliente miCliente = new Cliente();
            miCliente.setNombreCliente("No hay clientes");
            losClientes.add(miCliente);
        }
        return losClientes.iterator();
    }
    public void insertar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "
                    +this.getClass().getSimpleName()+" VALUES(NULL,?,?)");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"insertado correctamente");
        }catch(SQLException ex){
            System.err.println("error al insertar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE "+this.getClass().getSimpleName()+
                    " SET nombreCliente =?,documentoCliente=? WHERE idCliente =?");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setInt(3, this.getIdCliente());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+"modificado correctamente");
        }catch(SQLException ex){
            System.err.println("error al modificar"+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void eliminar(){
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" DELETE FROM "
                    +this.getClass().getSimpleName()+" WHERE idCliente = ?");
            sql.setInt(1,getIdCliente());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+" eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("error al elimminar"+this .getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Cliente> buscar (String busqueda){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName()
            +" WHERE nombreCliente LIKE ? OR documentoCliente LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            ResultSet rs =sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente=new Cliente();
                unCliente.setIdCliente(      rs.getInt ("idCliente"));
                unCliente.setNombreCliente(rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString("documentoCliente"));
                losClientes.add(unCliente);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar" +this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losClientes.iterator();
    }
    public Cliente buscarPorID (int elID){
        Cliente unCliente=new Cliente();
        unCliente.setNombreCliente("Cliente no existe");
        try{
            PreparedStatement sql =ConexionBD.conexion.prepareStatement(" SELECT * FROM "+
                    this.getClass().getSimpleName()+" WHERE idCliente = ? ");
            sql.setInt(1, elID);
            ResultSet rs =sql.executeQuery();
            while (rs.next()){
                unCliente.setIdCliente(    rs.getInt("idCliente"));
                unCliente.setNombreCliente(     rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(     rs.getString("documentoCliente"));
            }
        }catch (SQLException ex){
            System.err.println("error al buscar el id"+ex.getMessage());
        }
        return unCliente;
    }
}
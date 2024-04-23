/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import java.awt.event.ActionEvent;

/**
 *
 * @author coromoro
 */
public class ControladorCliente {
     public void controladorAccion(ActionEvent evento,Cliente unCliente){
        String accion=evento.getActionCommand();
        switch(accion){
            case "Insertar":
                unCliente.insertar();
            break;
            case "Modificar":
                unCliente.modificar();
            break;
            case "Eliminar":
                unCliente.eliminar();
            break;
        }
    }
}

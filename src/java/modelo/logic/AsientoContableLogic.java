/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.AsientoContable;
import modelo.dao.AsientoContableDao;

/**
 *
 * @author Jean Paul
 */
public class AsientoContableLogic {
    
    String msj;
    AsientoContableDao daoAC = new AsientoContableDao();
    AsientoContable beansAC = new AsientoContable();
    List<AsientoContable> asientos;
    
    public String Agregar(AsientoContable asiento) {
        
        asientos = daoAC.listar("");

        if (!"".equals(asiento.getNumero())
                && !"".equals(asiento.getGlosa()) 
                && !"".equals(asiento.getEstado())
                && !"".equals(asiento.getCodOperacion())
                && asiento.getIdPeriodo() > 0
                && asiento.getCodUsuario() > 0
                && !"".equals(asiento.getMoneda())) {

            int i = 0;
            int cont = 0;
            
            while (i < asientos.size()) {
                if (asiento.getNumero().equals(asientos.get(i).getNumero())) {
                    cont++;
                    break;
                }
                i++;
            }
            
            if (cont == 0) {
                
                
                msj = daoAC.Agregar(asiento);
                
                

            } else {
                msj = "ASIENTO EXISTENTE";
            }

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {
        
        asientos = daoAC.listar(busq);
        return asientos;
    }
    
    public int NumeroAsiento() {
        
        int n;
        n=daoAC.NumeroAsientos();
        return n;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.concepto.webservice;

import java.util.Set;

import javax.ws.rs.core.Application;

import py.com.concepto.webservice.util.DateTypeAdapter;
import py.com.concepto.webservice.util.GsonProvider;

/**
 *
 * @author rafael-pc
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    	resources.add(DateTypeAdapter.class);
    	resources.add(GsonProvider.class);
        resources.add(ProdutoWS.class);
        resources.add(ClassificacaoWS.class);
        resources.add(DeliveryWS.class);
        resources.add(ClienteWS.class);
        resources.add(CidadeWS.class);
        resources.add(FilialWS.class);
        resources.add(ParametroWS.class);
    }
    
}

package br.com.devdojo.projetoinicial.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by thiago on 20/05/2024.
 */
public class FacesUtils {

    public static void addErrorMessage(String key){
        addMessage(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
    }

    public static void addWarningMessage(String key){
        addMessage(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
    }

    public static void addSuccessMessage(String key){
        addMessage(FacesMessage.SEVERITY_ERROR, getBundleValue(key));
    }

    public static void addMessage(FacesMessage.Severity severity, String msg) {
        final FacesMessage facesMessage = new FacesMessage(severity, msg, "");
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setRedirect(true);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public static String getBundleValue(String key) {
        return FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "m").getString(key);
    }
}
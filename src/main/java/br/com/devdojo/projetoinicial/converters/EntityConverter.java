package br.com.devdojo.projetoinicial.converters;

import br.com.devdojo.projetoinicial.persistence.model.AbstractEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Map;

/**
 * Created by thiago on 20/05/2024.
 */
@FacesConverter(value = "entityConverter")
public class EntityConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }
        return this.getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && !value.equals("")) {
            AbstractEntity entity = (AbstractEntity) value;
            if (entity.getId() != null) {
                this.addAttribute(uiComponent, entity);
                return entity.getId().toString();
            }
            return value.toString();
        }
        return "";
    }

    public void addAttribute(UIComponent component, AbstractEntity abstractEntity) {
        this.getAttributesFrom(component).put(abstractEntity.getId().toString(), abstractEntity);
    }

    public Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
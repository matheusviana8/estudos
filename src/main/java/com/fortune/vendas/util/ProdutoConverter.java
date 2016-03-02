package com.fortune.vendas.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.fortune.vendas.model.Produto;
import com.fortune.vendas.repository.ProdutoRepository;

@FacesConverter
public class ProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Autowired
	private ProdutoRepository produtos;
	
	
  @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        
        Long id;
 
        try {
            id = Long.parseLong(arg2);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Dog and select it (or use the dropdow)", "Type the name of a Dog and select it (or use the dropdow)"));
        }
        System.out.println(produtos);
        return produtos.porId(id);
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
 
        if (arg2 == null) {
            return "";
        }
        Produto produto = (Produto) arg2;
        return String.valueOf(produto.getId());
    }*/
    
}
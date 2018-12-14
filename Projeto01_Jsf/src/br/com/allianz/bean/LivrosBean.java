package br.com.allianz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.allianz.dao.LivrosDao;
import br.com.allianz.models.Livro;

@ManagedBean(name="beanLivro")
@RequestScoped
public class LivrosBean {

	private Livro livro;
	
	public LivrosBean() {
		if(this.livro == null)
			this.livro = new Livro();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//método de ação (action) que, quando executado, retorna o
	//redirecionamento conforme o resultado da execução
	public String incluirLivro() {
		try {
			new LivrosDao().incluirLivro(this.livro);
			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}
	
	//propriedade usada para apresentar a lista dos livros cadastrados
	public List<Livro> listarLivros() throws Exception{
		return new LivrosDao().listarLivros();
		/*
		try {
			return new LivrosDao().listarLivros();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}*/
	}
}

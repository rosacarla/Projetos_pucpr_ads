package rest;

public class Empregado {
	
    private String id;

    private String nome;



    public Empregado() {

            super();

    }



    public Empregado(String id, String nome) {

            super();

            this.id = id;

            this.nome = nome;

    }



    public String getId() {

            return id;

    }



    public void setId(String id) {

            this.id = id;

    }



    public String getNome() {

            return nome;

    }



    public void setNome(String nome) {

            this.nome = nome;

    }



	public Object build() {
		// TODO Auto-generated method stub
		return null;
	}

}
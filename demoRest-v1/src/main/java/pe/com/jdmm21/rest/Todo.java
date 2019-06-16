package pe.com.jdmm21.rest;

public class Todo {
	
	private String text;
	private Long id;
	
	public Todo() {
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Todo(String text, Long id) {
		super();
		this.text = text;
		this.id = id;
	}
	
	

}

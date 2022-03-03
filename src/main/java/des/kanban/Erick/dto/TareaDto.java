package des.kanban.Erick.dto;

public class TareaDto {
	
	private int id_tarea;
	
	private String titulo;
	
	private String prioridad;
	
	private String estado;

	public TareaDto() {
		super();
	}

	public TareaDto(int id_tarea, String titulo, String prioridad, String estado) {
		super();
		this.id_tarea = id_tarea;
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.estado = estado;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}

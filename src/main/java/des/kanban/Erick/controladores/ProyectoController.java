package des.kanban.Erick.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import des.kanban.Erick.entidades.Proyecto;
import des.kanban.Erick.entidades.Tarea;
import des.kanban.Erick.entidades.Usuario;
import des.kanban.Erick.servicios.ProyectoServicio;
import des.kanban.Erick.servicios.UsuarioServicio;

@Controller
@RequestMapping("proyecto")
public class ProyectoController {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private ProyectoServicio servicioProyecto;
	

	@GetMapping("/{idProyecto}")
	public String getPerfilProyecto (@PathVariable int idProyecto, Model modelo) {
		
		Proyecto proyecto = servicioProyecto.obtenerProyectoPorId(idProyecto);
		modelo.addAttribute("proyecto", proyecto);
		
		List<Tarea> tareas = proyecto.getTareas();
		modelo.addAttribute("tareas", tareas);
		
		List<Usuario> empleados = proyecto.getTrabajadores();
		modelo.addAttribute("empleados", empleados);
		
		return "proyecto/perfilProyecto";
	}
	
	@PostMapping("/crear")
	public String crearProyecto (@RequestParam String nombreProyecto, String empleadosProyecto) {
		
		Proyecto proyecto = new Proyecto();
		proyecto.setNombre(nombreProyecto);
		
		servicioProyecto.crearProyecto(proyecto, empleadosProyecto);
		
		
		return "redirect:/";
	}
	
	@GetMapping("/borrar/{idProyecto}")
	public String borrarProyecto (@PathVariable int idProyecto) {
		
		servicioProyecto.borrarProyecto(idProyecto);
		
		return "redirect:/index";
	}
	
	@GetMapping("/buscar/{nombreProyecto}")
	public ModelAndView buscarProyecto (@PathVariable String nombreProyecto, @RequestParam String nombreProyecto1, Model modelo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		List<Proyecto> proyectos = servicioProyecto.obtenerProyectosPorNombre(nombreProyecto1);
		modelo.addAttribute("proyectos", proyectos);
		
		List<Usuario> usuarios = usuarioServicio.obtenerTodosLosUsuarios();
		modelo.addAttribute("empleados", usuarios);
		
		return mav;
	}
	
}

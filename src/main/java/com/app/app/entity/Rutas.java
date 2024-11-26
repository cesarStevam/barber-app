package com.app.app.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.app.repository.PersonaRepository;
import com.app.app.repository.RolRepository;
import com.app.app.services.CompraService;
import com.app.app.services.InventarioService;
import com.app.app.services.PersonaService;
import com.app.app.services.ProductoService;
import com.app.app.services.ProveedorService;
import com.app.app.services.ReciboService;
import com.app.app.services.ReservaService;
import com.app.app.services.RolService;

@Controller
public class Rutas {

    @Autowired
    private PersonaService personaService;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    private RolService rolService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ReciboService reciboService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/indexA")
    public String indexA() {
        return "indexA";
    }

    @GetMapping("/indexB")
    public String indexB() {
        return "indexB";
    }

    @GetMapping("/indexU")
    public String indexU() {
        return "indexU";
    }

    @GetMapping("/login")
    public String login() {
        return "login";

    }

    @GetMapping("/personas")
    public String mostrarPersonas(Model model) {
        List<Persona> personas = personaService.getPersonas();
        model.addAttribute("personas", personas);
        return "listaPersona";
    }

    @PostMapping("/AgregarPersona")
    public String savePersona(@ModelAttribute("persona") Persona persona) {
        personaService.saveOrUpdate(persona);

        System.out.println("Se registró la persona!!!!" + persona);
        return "redirect:/personas";
    }

    @GetMapping("/Agregarpersona")
    public String AgregarPersona(ModelMap model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("roles", rolService.getRoles());
        return "Agregarpersona";
    }

    // editarpersona
    @GetMapping("/editarpersona/{idPersonas}")
    public String editarPersona(@PathVariable("idPersonas") Long idPersonas, ModelMap Model) {
        Model.addAttribute("persona", new Persona());
        Optional<Persona> personas = personaService.getPersonaById(idPersonas);
        Model.addAttribute("persona", personas.orElse(null));
        List<Rol> roles = rolService.getRoles();
        Model.addAttribute("roles", roles);
        return "editarpersona";
    }

    // editarpersona
    @PostMapping("/editarpersona/editPersona")
    public String metodPostEdit(@ModelAttribute("persona") Persona persona) {
        personaService.saveOrUpdate(persona);
        return "redirect:/personas";
    }

    @GetMapping("/roles")
    public String mostrarRol(Model model) {
        List<Rol> roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        return "listaRol";
    }

    @GetMapping("/AgregarRol")
    public String agregarRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "AgregarRol"; // Nombre de la plantilla HTML para agregar un rol
    }

    @PostMapping("/AgregarRol")
    public String guardarRol(@ModelAttribute("rol") Rol rol) {
        rolService.saveOrUpdate(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editarRol/{idRol}")
    public String editarRol(@PathVariable("idRol") Long idRol, ModelMap model) {
        model.addAttribute("rol", new Rol());
        Optional<Rol> rol = rolService.getRolById(idRol);
        model.addAttribute("rol", rol.orElse(null));
        return "editarRol";
    }

    // editarRol
    @PostMapping("/editarRol/editRol")
    public String metodPostEdit(@ModelAttribute("rol") Rol rol) {
        rolService.saveOrUpdate(rol);
        return "redirect:/roles"; // Cambia la URL a donde deseas redirigir después de guardar
    }

    @GetMapping("/eliminarpersona/{idPersonas}")
    public String eliminarpersona(Model model, @PathVariable Long idPersonas) {
        personaService.eliminarpersona(idPersonas);
        return "redirect:/personas";
    }

    @GetMapping("/compras")
    public String mostrarCompras(Model model) {
        List<Compra> compras = compraService.getCompras();
        model.addAttribute("compras", compras);
        return "listaCompra"; // Asegúrate de que este sea el nombre correcto de la vista (archivo HTML).
    }

    @GetMapping("/AgregarCompra")
    public String agregarCompra(Model model) {
        model.addAttribute("compra", new Compra());
        return "AgregarCompra"; // Nombre de la plantilla HTML para agregar una compra
    }

    @PostMapping("/AgregarCompra")
    public String guardarCompra(@ModelAttribute("compra") Compra compra) {
        compraService.saveOrUpdate(compra);
        return "redirect:/compras"; // Redirige a la lista de compras después de guardar
    }

    // Método GET para mostrar el formulario de edición de compra
    @GetMapping("/editarcompra/{idCompras}")
    public String editarCompra(@PathVariable("idCompras") Long idCompras, ModelMap model) {
        model.addAttribute("compra", new Compra());
        Optional<Compra> compra = compraService.getCompraById(idCompras); // Supone que tienes este método en tu service
        model.addAttribute("compra", compra.orElse(null));
        return "editarcompra"; // Asegúrate de que este es el nombre correcto de la vista (archivo HTML)
    }

    // Método POST para actualizar la compra
    @PostMapping("/editarcompra/editCompra")
    public String metodPostEdit(@ModelAttribute("compra") Compra compra) {
        compraService.saveOrUpdate(compra); // Guardar o actualizar la compra
        return "redirect:/compras"; // Redirigir de vuelta a la lista de compras
    }

    @GetMapping("/eliminarcompra/{idCompras}")
    public String eliminarcompra(Model model, @PathVariable Long idCompras) {
        compraService.eliminarcompra(idCompras);
        return "redirect:/compras";
    }

    @GetMapping("/productos")
    public String listProductos(Model model) {
        List<Producto> productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "listaProducto";
    }

    @GetMapping("/AgregarProducto")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("producto", new Producto());
        return "agregarProducto";
    }

    @PostMapping("/AgregarProducto")
    public String agregarProducto(@ModelAttribute Producto producto) {
        productoService.saveOrUpdate(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editarproducto/{idProducto}")
    public String editarProducto(@PathVariable("idProducto") Long idProducto, ModelMap model) {
        model.addAttribute("producto", new Producto());
        Optional<Producto> producto = productoService.getProductoById(idProducto); // Asegúrate de que tienes este
                                                                                   // método en tu servicio
        model.addAttribute("producto", producto.orElse(null));
        return "editarproducto"; // Asegúrate de que este es el nombre correcto de la vista (archivo HTML)
    }

    // Método POST para actualizar el producto
    @PostMapping("/editarproducto/editProducto")
    public String metodPostEdit(@ModelAttribute("producto") Producto producto) {
        productoService.saveOrUpdate(producto); // Guardar o actualizar el producto
        return "redirect:/productos"; // Redirigir de vuelta a la lista de productos
    }

    @GetMapping("/eliminarproducto/{idProducto}")
    public String eliminarproducto(Model model, @PathVariable Long idProducto) {
        productoService.eliminarproducto(idProducto);
        return "redirect:/productos";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("roles", rolService.getRoles());
        return "register";
    }

    @PostMapping("/register")
    public String registerPersona(@ModelAttribute("persona") Persona persona, Model model) {

        if (personaRepository.findByNumeroDocumento(persona.getNumeroDocumento()).isPresent()) {
            model.addAttribute("error", "El número de documento ya está en uso.");
            return "register";
        }

        // Busca el rol de usuario
        Rol rolUsuario = rolRepository.findByNombreRol("Usuario")
                .orElseThrow(() -> new RuntimeException("Rol de usuario no encontrado"));

        // Asigna el rol al usuario
        persona.setRol(rolUsuario);

        // Guarda la persona en la base de datos
        personaService.saveOrUpdate(persona);

        return "redirect:/login";
    }

    @GetMapping("/reservas")
    public String mostrarReservas(Model model) {
        List<Reserva> reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return "listaReserva";
    }

    @GetMapping("/agregarreserva")
    public String AgregarReserva(ModelMap model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("personas", personaService.getPersonas());
        return "agregarreserva";
    }

    @PostMapping("/agregarreserva")
    public String saveReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaService.saveOrUpdate(reserva);
        System.out.println("Se registró la compra!!!!" + reserva);
        return "redirect:/reservas";
    }

    // editarreserva
    @GetMapping("/editarreserva/{idReservas}")
    public String editarReserva(@PathVariable("idReservas") Long idReservas, ModelMap Model) {
        Model.addAttribute("reserva", new Reserva());
        Optional<Reserva> reservas = reservaService.getReservaById(idReservas);
        Model.addAttribute("reserva", reservas.orElse(null));
        List<Persona> personas = personaService.getPersonas();
        Model.addAttribute("personas", personas);
        return "editarreserva";
    }

    // editarreserva
    @PostMapping("/editarreserva/editReserva")
    public String metodPostEdit(@ModelAttribute("reserva") Reserva reserva) {
        reservaService.saveOrUpdate(reserva);
        return "redirect:/reservas";
    }

    @PostMapping("/eliminarreserva/{idReservas}")
    public String eliminarReserva(@PathVariable("idReservas") Long idReservas) {
        reservaService.eliminarReserva(idReservas);
        return "redirect:/reservas";
    }

    @GetMapping("/proveedores")
    public String mostrarProveedor(Model model) {
        List<Proveedor> proveedor = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedor);
        return "listaProveedor"; // Asegúrate de que este sea el nombre correcto de la vista (archivo HTML).
    }

    @GetMapping("/AgregarProveedor")
    public String agregarProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "AgregarProveedor"; // Nombre de la plantilla HTML para agregar un Proveedor
    }

    @PostMapping("/AgregarProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.saveOrUpdate(proveedor);
        return "redirect:/proveedores"; // Redirige a la lista de proveedores después de guardar
    }

    // Método GET para mostrar el formulario de edición de compra
    @GetMapping("/editarproveedor/{idProveedor}")
    public String editarProveedor(@PathVariable("idProveedor") Long idProveedor, ModelMap model) {
        model.addAttribute("proveedor", new Proveedor());
        Optional<Proveedor> proveedor = proveedorService.getProveedorById(idProveedor); // Supone que tienes este método
                                                                                        // en tu service
        model.addAttribute("proveedor", proveedor.orElse(null));
        return "editarproveedor"; // Asegúrate de que este es el nombre correcto de la vista (archivo HTML)
    }

    // Método POST para actualizar la compra
    @PostMapping("/editarproveedor/editProveedor")
    public String metodPostEdit(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.saveOrUpdate(proveedor); // Guardar o actualizar la compra
        return "redirect:/proveedores"; // Redirigir de vuelta a la lista de compras
    }

    @GetMapping("/eliminarproveedor/{idProveedor}")
    public String eliminarproveedor(Model model, @PathVariable Long idProveedor) {
        proveedorService.eliminarproveedor(idProveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/recibos")
    public String mostrarRecibo(Model model) {
        List<Recibo> recibo = reciboService.getRecibo();
        model.addAttribute("recibo", recibo);
        return "listaRecibo"; // Asegúrate de que este sea el nombre correcto de la vista (archivo HTML).
    }

    @GetMapping("/AgregarRecibo")
    public String agregarRecibo(Model model) {
        model.addAttribute("recibo", new Recibo());
        return "AgregarRecibo"; // Nombre de la plantilla HTML para agregar un Recibo
    }

    @PostMapping("/AgregarRecibo")
    public String guardarRecibo(@ModelAttribute("recibo") Recibo recibo) {
        reciboService.saveOrUpdate(recibo);
        return "redirect:/recibos"; // Redirige a la lista de recibos después de guardar
    }

    // Método GET para mostrar el formulario de edición de compra
    @GetMapping("/editarrecibo/{idRecibo}")
    public String editarRecibo(@PathVariable("idRecibo") Long idRecibo, ModelMap model) {
        model.addAttribute("recibo", new Recibo());
        Optional<Recibo> recibo = reciboService.getReciboById(idRecibo); // Supone que tienes este método en tu service
        model.addAttribute("recibo", recibo.orElse(null));
        return "editarrecibo"; // Asegúrate de que este es el nombre correcto de la vista (archivo HTML)
    }

    // Método POST para actualizar la compra
    @PostMapping("/editarrecibo/editRecibo")
    public String metodPostEdit(@ModelAttribute("recibo") Recibo recibo) {
        reciboService.saveOrUpdate(recibo); // Guardar o actualizar la compra
        return "redirect:/recibos"; // Redirigir de vuelta a la lista de compras
    }

    @GetMapping("/eliminarrecibo/{idRecibo}")
    public String eliminarrecibo(Model model, @PathVariable Long idRecibo) {
        reciboService.eliminarrecibo(idRecibo);
        return "redirect:/recibos";
    }

    @GetMapping("/inventario")
    public String mostrarInventario(Model model) {
        List<Inventario> inventario = inventarioService.getInventario();
        model.addAttribute("inventario", inventario);
        return "listainventario"; // Asegúrate de que este sea el nombre correcto de la vista (archivo HTML).
    }

    @GetMapping("/AgregarInventario")
    public String agregarInventario(Model model) {
        model.addAttribute("inventario", new Inventario());
        return "AgregarInventario"; // Nombre de la plantilla HTML para agregar un Inventario
    }

    @PostMapping("/AgregarInventario")
    public String guardarInventario(@ModelAttribute("inventario") Inventario inventario) {
        inventarioService.saveOrUpdate(inventario);
        return "redirect:/inventario"; // Redirige a la lista de recibos después de guardar
    }

    // Método GET para mostrar el formulario de edición de compra
    @GetMapping("/editarinventario/{idInventario}")
    public String editarInventario(@PathVariable("idInventario") Long idInventario, ModelMap model) {
        model.addAttribute("inventario", new Inventario());
        Optional<Inventario> inventario = inventarioService.getInventarioById(idInventario); // Supone que tienes este
                                                                                             // método en tu service
        model.addAttribute("inventario", inventario.orElse(null));
        return "editarinventario"; // Asegúrate de que este es el nombre correcto de la vista (archivo HTML)
    }

    // Método POST para actualizar la compra
    @PostMapping("/editarinventario/editInventario")
    public String metodPostEdit(@ModelAttribute("inventario") Inventario inventario) {
        inventarioService.saveOrUpdate(inventario); // Guardar o actualizar la compra
        return "redirect:/inventario"; // Redirigir de vuelta a la lista de compras
    }

    @GetMapping("/eliminarinventario/{idInventario}")
    public String eliminarinventario(Model model, @PathVariable Long idInventario) {
        inventarioService.eliminarinventario(idInventario);
        return "redirect:/inventario";
    }

}
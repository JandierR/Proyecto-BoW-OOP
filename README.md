Proyecto Domain – Lógica de Negocio y Modelo del Sistema

Este repositorio contiene la capa Domain del sistema de gestión de tickets. Su propósito es centralizar todas las clases del modelo, la lógica de negocio y las estructuras de datos que permiten el funcionamiento del proyecto sin depender de la interfaz ni de la entrada del usuario.

La arquitectura sigue un enfoque por capas, donde Domain actúa como el núcleo del sistema: procesa reglas, valida información y gestiona las entidades principales.

Objetivo del Proyecto

El sistema busca modelar el proceso de registro, gestión y análisis básico de tickets, usuarios y departamentos. La capa Domain reúne todos los componentes encargados de:

Representar entidades del sistema (como Usuario, Departamento y Ticket).

Controlar la lógica de negocio mediante gestores dedicados.

Administrar las colecciones internas mediante la base de datos de cada entidad.

Aplicar la funcionalidad principal del analisis de bag of words en la clase clase AnalisisBoW

Estructura del Proyecto

El repositorio incluye las siguientes categorías principales de clases:

1. Entidades (Model)

Clases que representan los objetos del dominio:

Usuario

Departamento

Ticket

Palabra

PalabraEmocional

PalabraTecnica

Estas clases contienen atributos, constructores y comportamiento básico, incluyendo métodos toString para representar datos de forma legible.

2. Lógica de Negocio (Gestores)

Clases que procesan reglas e implementan operaciones de alto nivel:

GestorUsuario

GestorDepartamento

GestorTicket

GestorDiccionarioEmocional

GestorDiccionarioTecnico

AnalisisBoW

Login

Cada gestor encapsula la lógica necesaria para registrar, buscar y validar objetos del sistema utilizando los datos almacenados.

Además, el analisisBoW tiene lugar en esta capa porque es la que permite lograr toda la lógica por detrás para llevar a cabo el bag of words

Incluso, la clase Login quien permite que se lleve a cabo un proceso de inicio de sesión en el sistema.

3. Gestión de Datos (Data Layer)

Esta capa contiene las bases de dato de cada entidad y sus conexiones, manteniendo sus métodos esenciales en relación con la base de datos. Las clases de cada entidad son:

UsuarioDAO

DepartamentoDAO

TicketDAO

PalabrasEmocionalDAO

PalabraTecnicaDAO

4. Módulos Adicionales

Incluye clases como Login, que permiten validar credenciales respetando las reglas del dominio y sin depender de la interfaz gráfica o textual.

Características Clave

Independencia completa de la capa UI.

Organización clara por responsabilidades.

Facilidad para extender el proyecto con nuevas funcionalidades.

Cómo Usar este Proyecto

Este repositorio no se ejecuta por sí solo. Debe ser utilizado como dependencia del repositorio UI, el cual se encarga de solicitar datos y mostrar resultados al usuario.

Instrucciones de ejecución:

Ejecuta la clase Main desde el proyecto UI.

Al ejecutar, iniciar sesión o registrar un usuario.

Al iniciar, el sistema mostrará el menú principal con las opciones disponibles:

1. Registrar usuario

2. Registrar departamento

3. Listar tickets, etc.

Seguir las instrucciones que hay en la consola cuando se ingresa una opción del menú. Siempre darle enter cada vez que ingresa información que se le pide, hasta que se le indique exitosamente su pedido.

Cuando desee terminar el programa, simplemente digite la opción de salida, que sería la número 0 en el menú. 


Proyecto Domain – Lógica de Negocio y Modelo del Sistema

Este repositorio contiene la capa Domain del sistema de gestión de tickets. Su propósito es centralizar todas las clases del modelo, la lógica de negocio y las estructuras de datos que permiten el funcionamiento del proyecto sin depender de la interfaz ni de la entrada del usuario.

La arquitectura sigue un enfoque por capas, donde Domain actúa como el núcleo del sistema: procesa reglas, valida información y gestiona las entidades principales.

Objetivo del Proyecto

El sistema busca modelar el proceso de registro, gestión y análisis básico de tickets, usuarios y departamentos. La capa Domain reúne todos los componentes encargados de:

Representar entidades del sistema (como Usuario, Departamento y Ticket).

Controlar la lógica de negocio mediante gestores dedicados.

Administrar las colecciones internas mediante la clase Data.

Preparar la base para futuras funcionalidades como el análisis de Bag of Words.

Estructura del Proyecto

El repositorio incluye las siguientes categorías principales de clases:

1. Entidades (Model)

Clases que representan los objetos del dominio:

Usuario

Departamento

Ticket

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

Cada gestor encapsula la lógica necesaria para registrar, buscar y validar objetos del sistema utilizando los datos almacenados.

3. Gestión de Datos (Data Layer)

La clase Data funciona como un contenedor centralizado para las colecciones del sistema. Actúa como un repositorio simple en memoria para almacenar y recuperar listas de:

Usuarios

Departamentos

Tickets

Palabras emocionales

Palabras técnicas

4. Módulos Adicionales

Incluye clases como Login, que permiten validar credenciales respetando las reglas del dominio y sin depender de la interfaz gráfica o textual.

Características Clave

Independencia completa de la capa UI.

Organización clara por responsabilidades.

Facilidad para extender el proyecto con nuevas funcionalidades.

Preparación para integrar procesamiento de Bag of Words en versiones futuras.

Cómo Usar este Proyecto

Este repositorio no se ejecuta por sí solo. Debe ser utilizado como dependencia del repositorio UI, el cual se encarga de solicitar datos y mostrar resultados al usuario.

Para utilizar la capa Domain en otro proyecto:

1. Importar las clases del paquete correspondiente.

2. Instanciar Data.

3. Crear los distintos managers pasando Data como dependencia.

4. Llamar sus métodos para registrar u obtener información del sistema.

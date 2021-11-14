# RETO DÍA 7
## Crea 4 clases, Usuario (clase abstracta), Estudiante (hereda de Usuario), Invitado  (hereda de Usuario) y Administrador (hereda de Usuario y tiene nivel), cada uno con sus atributos (no hacen falta métodos). 
## En el método Main, debes crear una lista (List) de Usuarios. Para cada elemento:
      - Si es de tipo Invitado, debes mostrarle el mensaje "No estás autorizado a entrar en esta lección".
      - Si es de tipo Estudiante, debes comprobar que su $nombre y $password existe y mostrar el mensaje "Bienvenid@ a OpenVitae, $nombre".
      - Si es de tipo Administrador y su nivel es 1, debes mostrar el mensaje "Tu nivel es insuficiente".
      - Si es de tipo Administrador y su nivel es 2, debes mostrar el mensaje "Tu nivel es el correcto".
* Lenguaje: Scala
* IDE recomendado: IntelliJ
* Nivel: Intermedio
* Consideraciones: Debes usar una de las funcionalidades más potentes de Scala, llamada pattern matching.